import java.util.{Date, UUID}

import commons.conf.ConfigurationManager
import commons.constant.Constants
import commons.model.UserVisitAction
import commons.utils.{DateUtils, ParamUtils, StringUtils}
import net.sf.json.JSONObject
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object MySessionStat {

  def main(args: Array[String]): Unit = {

    // 获取筛选条件
    val jsonStr = ConfigurationManager.config.getString(Constants.TASK_PARAMS)

    val taskParam = JSONObject.fromObject(jsonStr)

    val taskUUID = UUID.randomUUID().toString
    val sparkConf = new SparkConf().setAppName("session").setMaster("local[*]")

    var sparkSession: SparkSession = SparkSession
      .builder()
      .config(sparkConf)
      .enableHiveSupport()
      .getOrCreate();
    // 获取原始的动作表数据
    // actionRDD: RDD[UserVisitAction]
    val actionRDD = getOriActionRDD(sparkSession, taskParam)

    // sessionId2ActionRDD: RDD[(sessionId, UserVisitAction)]
    val sessionId2ActionRDD = actionRDD.map(item => (item.session_id, item))

    // session2GroupActionRDD: RDD[(sessionId, iterable_UserVisitAction)]
    val session2GroupActionRDD = sessionId2ActionRDD.groupByKey()
    session2GroupActionRDD.cache()

    val userId2AggrInfoRDD = getSessionFullInfo(sparkSession, session2GroupActionRDD)

    userId2AggrInfoRDD.foreach(println(_))
  }

  def getSessionFullInfo(sparkSession: SparkSession,
                         session2GroupActionRDD: RDD[(String, Iterable[UserVisitAction])]) = {

      val userId2AggreInfoRDD=session2GroupActionRDD.map {
        case (sessionId, iterableAction) => {
          var sessionId = -1L;
          var searchKeyWords = new StringBuffer("");
          var clickCategoryId = new StringBuffer("");
          var stepLength = 0;
          var startTime:Date = null;
          var endTime:Date = null;
          for (action <- iterableAction) {
            if (sessionId == -1L) {
              sessionId = action.user_id;
            }
            val search_keyword = action.search_keyword
            if(StringUtils.isNotEmpty(search_keyword)  && !searchKeyWords.toString.contains(search_keyword)){
                searchKeyWords.append(search_keyword+",")
            }
            val click_category_id = action.click_category_id
            if(click_category_id != -1 && !clickCategoryId.toString.contains(click_category_id)){
              clickCategoryId.append(click_category_id+",");
            }
            val actionTime=DateUtils.parseTime(action.action_time);
            if  (startTime==null || startTime.after(actionTime)){
                startTime=actionTime
            }
            if(endTime == null || endTime.before(actionTime)){
              endTime = actionTime
            }
            stepLength+=1;
          }
          val searchKw=StringUtils.trimComma(searchKeyWords.toString)
          val clickCg=StringUtils.trimComma(clickCategoryId.toString)
          val visitLength = (endTime.getTime - startTime.getTime) / 1000

          val aggrInfo=Constants.FIELD_SESSION_ID+ "=" +sessionId+"|" +
            Constants.FIELD_SEARCH_KEYWORDS+"="+searchKeyWords+"|"+
            Constants.FIELD_CLICK_CATEGORY_IDS+"="+clickCategoryId+"|"+
            Constants.FIELD_VISIT_LENGTH+"="+visitLength+"|"+
            Constants.FIELD_STEP_LENGTH+"="+stepLength+"|"+
            Constants.FIELD_START_TIME+"="+startTime+"|"+DateUtils.formatDate(startTime);
          (sessionId,aggrInfo)
        }
      }
    userId2AggreInfoRDD

  }

  def getOriActionRDD(sparkSession: SparkSession, taskParam: JSONObject) = {
    val startDate = ParamUtils.getParam(taskParam, Constants.PARAM_START_DATE)
    val endDate = ParamUtils.getParam(taskParam, Constants.PARAM_END_DATE)

    val sql = "select * from user_visit_action where date>='" + startDate + "' and date<='" + endDate + "'"

    import sparkSession.implicits._
    sparkSession.sql(sql).as[UserVisitAction].rdd
  }


}
