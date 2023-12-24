import com.example.news.Model.NewsResponseClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("top-headlines?country=us&category=business&apiKey=bf151d295f6d4fd6b76e969221457183")
    suspend  fun getAllNews() : NewsResponseClass
    @GET("https://newsapi.org/v2/everything?domains=wsj.com&apiKey=bf151d295f6d4fd6b76e969221457183")

    suspend fun GetAllNewsForSixMonthes():NewsResponseClass
}