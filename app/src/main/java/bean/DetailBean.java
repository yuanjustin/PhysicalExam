package bean;

import com.Justin.Yuan.ClinicalSkillApp.MainActivity;

public class DetailBean
{
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title ;
    String detail ;

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    String detailText ;
    DetailBean(String detail, String title, MainActivity mainActivity){

        this.detail=detail;
        this.title=title;


    }

//    public String getBrief() {
//        return detail;
//    }
}