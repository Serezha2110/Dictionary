package sample;

public class Words {

    private int id;
    private String wordRu;
    private String wordEn;

    public Words(int id, String wordRu, String wordEn) {
        this.id = id;
        this.wordRu = wordRu;
        this.wordEn = wordEn;
    }

    public Words() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordRu() {
        return wordRu;
    }

    public void setWordRu(String wordRu) {
        this.wordRu = wordRu;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }
}