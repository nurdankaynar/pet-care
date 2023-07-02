package com.android.petcare.database.entities;

import android.content.Context;
import com.android.petcare.database.entities.reminder.ReminderDAO;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.android.petcare.DateTypeConverter;
import androidx.room.TypeConverters;
import com.android.petcare.database.entities.reminder.Reminders;
import com.android.petcare.database.entities.articles.Articles;
import com.android.petcare.database.entities.articles.ArticlesDao;
import com.android.petcare.database.entities.labtest.LabTest;
import com.android.petcare.database.entities.labtest.LabTestDao;
import com.android.petcare.database.entities.medicine.Medicine;
import com.android.petcare.database.entities.medicine.MedicineDao;
import com.android.petcare.database.entities.user.User;
import com.android.petcare.database.entities.user.UserDao;
import com.android.petcare.database.entities.vet.Veteriner;
import com.android.petcare.database.entities.vet.VeterinerDao;


@Database(entities = {User.class, Articles.class, LabTest.class, Medicine.class, Veteriner.class, Reminders.class}, version = 1, exportSchema = false)
@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract ArticlesDao articlesDao();

    public abstract LabTestDao labTestDao();

    public abstract MedicineDao medicineDao();

    public abstract VeterinerDao veterinerDao();

    private static AppDatabase INSTANCE;

    public abstract ReminderDAO getReminderDAO();

    public static AppDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DbPetCare")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}