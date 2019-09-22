package com.tan.en.day03worka.bean;

import android.widget.Button;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by en on 2019/9/20.
 */
@Entity
public  class DatasBean {
    /**
     * id : 296282
     * uid : 1081365
     * name :
     * title : 如何创作艺术
     就是怎样生活
     * excerpt : 探索那叫你写的缘由，考察它的根是不是盘在你心的深处；你要坦白承认，万一你写不出来，是不是必得因此而死去。
     * lead : 对于一个刚刚跨入创作门槛的人而言，很难不把讨好他人放在过分重要的位置，仿佛作品有无价值全凭别人的一句评价。诗人莱纳·玛利亚·里尔克就收到过这样一位青年诗人的来信，惴惴不安地询问自己的诗艺到底好不好。里尔克直截了当地劝告他，停止向外看，走向自己的内心吧！往后，二人时不时地互通信件。
     里尔克留下了十封信，在他的论述中，艺术创作和日常生活是一体的，如何创作艺术就是怎样生活，好的作品是挖掘生活深处后的“必须”。因此里尔克在告知创作要诀时，也耐心回应了青年人常有的人生困惑：感官的快感，抑或精神的重负，这些体验都无需诋毁、厌弃，因为它们都通向生活内在的丰富，当真实的生活自然地生长起来时，比起那些高深、复杂的阐释，都要更为接近艺术。
     在信件中热心为他人排忧解难的里尔克会让人误以为彼时他已是一位饱经沧桑的老人，所以才能对生命的本质有如此清醒而深刻的认识，但其实里尔克写作这些信件时，也不过三十岁左右。对今天的青年人来说，不管是否有志于从事艺术创作，如果有意谴责自己的生活，仍能从他绵柔却坚韧的字句里得到宽慰，“寂寞而勇敢地生活在任何一处无情的现实中”。
     * model : 1
     * position : 0
     * thumbnail : https://img.owspace.com/Public/uploads/Picture/2019-09-19/5d83941422b01.jpg
     * create_time : 1568939400
     * update_time : 2019/09/20
     * tags : [{"name":""}]
     * status : 1
     * video :
     * fm :
     * link_url :
     * publish_time : 0
     * view : 2.7w
     * share : http://static.owspace.com/wap/296282.html
     * comment : 4
     * good : 10
     * bookmark : 0
     * show_uid : 1081365
     * fm_play :
     * lunar_type : 1
     * hot_comments : []
     * html5 : http://static.owspace.com/wap/296282.html
     * author : 莱内·马利亚·里尔克
     * tpl : 1
     * avatar : https://img.owspace.com/Public/static/avatar/4.png
     * discover : 0
     * category : TO READ
     * parseXML : 1
     */
    @Id
    private Long id;
    private String title;
    private String thumbnail;
    private String author;
    private int btn;
    @Generated(hash = 1375802970)
    public DatasBean(Long id, String title, String thumbnail, String author, int btn) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.author = author;
        this.btn = btn;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBtn() {
        return this.btn;
    }
    public void setBtn(int btn) {
        this.btn = btn;
    }


}
