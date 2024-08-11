import lombok.*;

import java.time.OffsetDateTime;

// прописать проверку входных данных checkthing()
// create message class with input to Note type
// парсю message - класс-передатчик? известно ли о Note?
// парсер прописать в Note - специализация класса
// тогда как брать message?
// передавать текстом
// что брать на геттер? как приглашение ко вводу осуществляется?
// message парсит по csv ";" в массив по каждому слову и итое слово для этой коллекции я беру + проверяю
// на выполенение ненулевых условий!
// а если что-то null? - пропуск в csv - а ввод пользователя? - пропуск
// написать отдельный класс для Note, который будет получать данные из ввода
// месседж каждый раз берётся к каждой строке - я сендю в месседж принт в консоль, он принтится, а потом я отправляю запрос на ввод с консоли

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Note {
    private int id; // авто-генерация
    private String title; // не null
    private String description;
    private OffsetDateTime timeOfCReation; // auto
    private NoteType typeOfNote;
    private PriorityType typeOfPriority;
    private OffsetDateTime timeOfReminder;

    public Note(int id, String messageTitle, String messageDescription, OffsetDateTime offsetDateTime, String messageTypeOfNote, String messageTypeOfPriority, String messageTypeOfReminder) {
    }

    public static Note createFromInput(Message message) {
        return new Note( // просто заполняем коллекцию мессаджем.
                0,
                getMessageTitle(message),
                getMessageDescription(message),
                null,
                getMessageTypeOfNote(message),
                getMessageTypeOfPriority(message),
                getMessageTypeOfReminder(message));
    }

    public static String getMessageTitle(Message message) {
        return message.getMessage("Введите заголовок заметки: ").toString();
    }
    public static String getMessageDescription(Message message) {
        return message.getMessage("Введите описание заметки: ").toString();
    }
    public static String getMessageTypeOfNote(Message message) {
        return message.getMessage("Введите вид заметки: ").toString();
    }
    public static String getMessageTypeOfPriority(Message message) {
        return message.getMessage("Введите приоритетность заметки: ").toString();
    }
    public static String getMessageTypeOfReminder(Message message) {
        return message.getMessage("Введите время напоминания: ").toString();
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", title=" + title + ", description" + description +
                ", timeOfCreation=" + timeOfCReation + ", typeOfPriority=" + typeOfPriority +
                ", timeOfRemainder=" + timeOfReminder + "}";
    }

}
