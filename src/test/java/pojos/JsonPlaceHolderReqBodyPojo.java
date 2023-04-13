package pojos;

public class JsonPlaceHolderReqBodyPojo {

    /*
     {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    // 1 - Tüm key değerlerini class level'da aldıkları data türüne göre
    //      private veriable olarak oluşturalım

    private String title;
    private String body;
    private int userId;
    private int id;

    // 2 - Tüm veriableler için getter()-setter() methodlarını oluşturalım


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3 - Tüm veriableleri içeren parametreli bir constructor oluşturalım


    public JsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4 - Parametreli constructor'u oluşturduğum için bir tane de parametresiz constructor oluşturuyorum

    public JsonPlaceHolderReqBodyPojo() {
    }

    // 5 - toString() oluşturuyorum


    @Override
    public String toString() {
        return "JsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }



}
