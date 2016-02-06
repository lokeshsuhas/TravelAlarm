package headout.travelalarm;

/**
 * Created by Lokesh on 07-02-2016.
 */
import dagger.Module;

@Module(
        injects = {
                AlarmActivity.class
        },
        complete = false,
        library = true
)
public final class UiModule {
}