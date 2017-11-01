package com.example.zhujie2;

/**
 * Created by 陈令鸽 on 2017/11/1.
 */

public class BookEntity {

    /**
     * errNo : 0
     * errMsg : OK
     * data : {"id":5,"title":"MySQL蹇呯煡蹇呬細","type":"鏁版嵁搴�","description":"绱ц创瀹炴垬闇\u20ac瑕侊紝閫傜敤浜庡箍澶ц蒋浠跺紑鍙戝拰鏁版嵁搴撶鐞嗕汉鍛樺涔犲弬鑰�","picture":"http://img13.360buyimg.com/n1/jfs/t2593/48/3523110588/234188/577f99d9/5791b08fN4ebfbc11.png","isRecommend":false,"dtCreated":"00-00 00:05"}
     */

    private int errNo;
    private String errMsg;
    private DataBean data;

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * title : MySQL蹇呯煡蹇呬細
         * type : 鏁版嵁搴�
         * description : 绱ц创瀹炴垬闇€瑕侊紝閫傜敤浜庡箍澶ц蒋浠跺紑鍙戝拰鏁版嵁搴撶鐞嗕汉鍛樺涔犲弬鑰�
         * picture : http://img13.360buyimg.com/n1/jfs/t2593/48/3523110588/234188/577f99d9/5791b08fN4ebfbc11.png
         * isRecommend : false
         * dtCreated : 00-00 00:05
         */

        private int id;
        private String title;
        private String type;
        private String description;
        private String picture;
        private boolean isRecommend;
        private String dtCreated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public boolean isIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(boolean isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getDtCreated() {
            return dtCreated;
        }

        public void setDtCreated(String dtCreated) {
            this.dtCreated = dtCreated;
        }
    }
}
