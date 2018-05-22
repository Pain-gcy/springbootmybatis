package com.imooc.springbootmybatis.entity;

import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 21 17:26
 */
public class Test {

    /**
     * Request : {"BusiParams":{"VasOfferInfo":{"OfferId":"111140088850","OperType":"0","AttrInstInfo":[{"AttrValue":"0","AttrName":"牌照方","AttrId":"151000001950","state":"1"},{"AttrValue":"2","AttrName":"账号","AttrId":"151000001953","state":"1"}]},"ServiceNum":"15140282642","Remark":""},"BusiCode":"OI_OrderVasOffer"}
     * PubInfo : {"InterfaceId":"","TransactionId":"GBH20180409115747364323383980484928","InterfaceType":"24","OpId":"1000061351","CountyCode":"","OrgId":"24000000","ClientIP":"","TransactionTime":"20180409115747","RegionCode":"240"}
     */

    private RequestBean Request;
    private PubInfoBean PubInfo;

    public RequestBean getRequest() {
        return Request;
    }

    public void setRequest(RequestBean Request) {
        this.Request = Request;
    }

    public PubInfoBean getPubInfo() {
        return PubInfo;
    }

    public void setPubInfo(PubInfoBean PubInfo) {
        this.PubInfo = PubInfo;
    }

    public static class RequestBean {
        /**
         * BusiParams : {"VasOfferInfo":{"OfferId":"111140088850","OperType":"0","AttrInstInfo":[{"AttrValue":"0","AttrName":"牌照方","AttrId":"151000001950","state":"1"},{"AttrValue":"2","AttrName":"账号","AttrId":"151000001953","state":"1"}]},"ServiceNum":"15140282642","Remark":""}
         * BusiCode : OI_OrderVasOffer
         */

        private BusiParamsBean BusiParams;
        private String BusiCode;

        public BusiParamsBean getBusiParams() {
            return BusiParams;
        }

        public void setBusiParams(BusiParamsBean BusiParams) {
            this.BusiParams = BusiParams;
        }

        public String getBusiCode() {
            return BusiCode;
        }

        public void setBusiCode(String BusiCode) {
            this.BusiCode = BusiCode;
        }

        public static class BusiParamsBean {
            /**
             * VasOfferInfo : {"OfferId":"111140088850","OperType":"0","AttrInstInfo":[{"AttrValue":"0","AttrName":"牌照方","AttrId":"151000001950","state":"1"},{"AttrValue":"2","AttrName":"账号","AttrId":"151000001953","state":"1"}]}
             * ServiceNum : 15140282642
             * Remark :
             */

            private VasOfferInfoBean VasOfferInfo;
            private String ServiceNum;
            private String Remark;

            public VasOfferInfoBean getVasOfferInfo() {
                return VasOfferInfo;
            }

            public void setVasOfferInfo(VasOfferInfoBean VasOfferInfo) {
                this.VasOfferInfo = VasOfferInfo;
            }

            public String getServiceNum() {
                return ServiceNum;
            }

            public void setServiceNum(String ServiceNum) {
                this.ServiceNum = ServiceNum;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public static class VasOfferInfoBean {
                /**
                 * OfferId : 111140088850
                 * OperType : 0
                 * AttrInstInfo : [{"AttrValue":"0","AttrName":"牌照方","AttrId":"151000001950","state":"1"},{"AttrValue":"2","AttrName":"账号","AttrId":"151000001953","state":"1"}]
                 */

                private String OfferId;
                private String OperType;
                private List<AttrInstInfoBean> AttrInstInfo;

                public String getOfferId() {
                    return OfferId;
                }

                public void setOfferId(String OfferId) {
                    this.OfferId = OfferId;
                }

                public String getOperType() {
                    return OperType;
                }

                public void setOperType(String OperType) {
                    this.OperType = OperType;
                }

                public List<AttrInstInfoBean> getAttrInstInfo() {
                    return AttrInstInfo;
                }

                public void setAttrInstInfo(List<AttrInstInfoBean> AttrInstInfo) {
                    this.AttrInstInfo = AttrInstInfo;
                }

                public static class AttrInstInfoBean {
                    /**
                     * AttrValue : 0
                     * AttrName : 牌照方
                     * AttrId : 151000001950
                     * state : 1
                     */

                    private String AttrValue;
                    private String AttrName;
                    private String AttrId;
                    private String state;

                    public String getAttrValue() {
                        return AttrValue;
                    }

                    public void setAttrValue(String AttrValue) {
                        this.AttrValue = AttrValue;
                    }

                    public String getAttrName() {
                        return AttrName;
                    }

                    public void setAttrName(String AttrName) {
                        this.AttrName = AttrName;
                    }

                    public String getAttrId() {
                        return AttrId;
                    }

                    public void setAttrId(String AttrId) {
                        this.AttrId = AttrId;
                    }

                    public String getState() {
                        return state;
                    }

                    public void setState(String state) {
                        this.state = state;
                    }
                }
            }
        }
    }

    public static class PubInfoBean {
        /**
         * InterfaceId :
         * TransactionId : GBH20180409115747364323383980484928
         * InterfaceType : 24
         * OpId : 1000061351
         * CountyCode :
         * OrgId : 24000000
         * ClientIP :
         * TransactionTime : 20180409115747
         * RegionCode : 240
         */

        private String InterfaceId;
        private String TransactionId;
        private String InterfaceType;
        private String OpId;
        private String CountyCode;
        private String OrgId;
        private String ClientIP;
        private String TransactionTime;
        private String RegionCode;

        public String getInterfaceId() {
            return InterfaceId;
        }

        public void setInterfaceId(String InterfaceId) {
            this.InterfaceId = InterfaceId;
        }

        public String getTransactionId() {
            return TransactionId;
        }

        public void setTransactionId(String TransactionId) {
            this.TransactionId = TransactionId;
        }

        public String getInterfaceType() {
            return InterfaceType;
        }

        public void setInterfaceType(String InterfaceType) {
            this.InterfaceType = InterfaceType;
        }

        public String getOpId() {
            return OpId;
        }

        public void setOpId(String OpId) {
            this.OpId = OpId;
        }

        public String getCountyCode() {
            return CountyCode;
        }

        public void setCountyCode(String CountyCode) {
            this.CountyCode = CountyCode;
        }

        public String getOrgId() {
            return OrgId;
        }

        public void setOrgId(String OrgId) {
            this.OrgId = OrgId;
        }

        public String getClientIP() {
            return ClientIP;
        }

        public void setClientIP(String ClientIP) {
            this.ClientIP = ClientIP;
        }

        public String getTransactionTime() {
            return TransactionTime;
        }

        public void setTransactionTime(String TransactionTime) {
            this.TransactionTime = TransactionTime;
        }

        public String getRegionCode() {
            return RegionCode;
        }

        public void setRegionCode(String RegionCode) {
            this.RegionCode = RegionCode;
        }
    }
}
