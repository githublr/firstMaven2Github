import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zack.lr on 2017/6/17.
 */
public class ThreadLocalTest {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };

    public static DateFormat getDateFormat_lr(){
        return (DateFormat)threadLocal.get();
    }

    public static Date parse(String textDate) throws ParseException {
        return getDateFormat_lr().parse(textDate);
    }

    public static String parse2(Date textDate) {
        return getDateFormat_lr().format(textDate);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(ThreadLocalTest.parse("2017-06-17 17:57:55"));
        System.out.println(ThreadLocalTest.parse2(new Date()));
    }

    /*  the output:
        Sat Jun 17 17:57:55 CST 2017
        2017-06-17 18:03:59
     */
}
