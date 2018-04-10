package linklist;

/**
 * Created by Administrator on 2018/4/10.
 */

public class ComException {

    public ComException(String message){
        try {
            throw new Exception(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
