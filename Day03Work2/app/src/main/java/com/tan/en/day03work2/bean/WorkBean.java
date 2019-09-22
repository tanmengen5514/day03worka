package com.tan.en.day03work2.bean;

import java.util.List;

/**
 * Created by en on 2019/9/22.
 */

public class WorkBean {
    /**
     * code : 200
     * body : {"result":[{"teacherpowerid":"0","description":"介绍"},{"teacherpowerid":1,"description":"课程"},{"teacherpowerid":"3","description":"专题"}]}
     * message : Succes!
     */

    private int code;
    private BodyBean body;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * teacherpowerid : 0
             * description : 介绍
             */

            private String teacherpowerid;
            private String description;

            public String getTeacherpowerid() {
                return teacherpowerid;
            }

            public void setTeacherpowerid(String teacherpowerid) {
                this.teacherpowerid = teacherpowerid;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return "ResultBean{" +
                        "teacherpowerid='" + teacherpowerid + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "result=" + result +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WorkBean{" +
                "code=" + code +
                ", body=" + body +
                ", message='" + message + '\'' +
                '}';
    }
}
