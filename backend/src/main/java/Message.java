public class Message {
    String s;
    public Message getMessage(String s) {
        sendMessage(s);
        return new Message();
    }
    public String sendMessage(String s) {
        return s;
    }
}
