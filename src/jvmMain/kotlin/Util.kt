import java.util.*

fun horaActual(): String{
    return Calendar.getInstance().time.toString().substring(11..18)
}