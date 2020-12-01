package com.example.minicompany.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.minicompany.R;
import com.example.minicompany.models.PopularFieldsModel;
import com.example.minicompany.models.UserModel;
import com.example.minicompany.models.jobModel;
import com.example.minicompany.models.jobProviderModel;
import com.example.minicompany.models.resumeModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static int ID = 0;
    private static int Popular_ID = 0;
    private static int Provider_ID = 0;

    private static Gson gson = new Gson();
    private static Type jobType = new TypeToken<ArrayList<jobModel>>(){}.getType();
    private static Type popularType = new TypeToken<ArrayList<PopularFieldsModel>>(){}.getType();
    private static Type resumeModelType = new TypeToken<resumeModel>(){}.getType();
    private static Type userType = new TypeToken<UserModel>(){}.getType();
    private static Type jobProviderType = new TypeToken<ArrayList<jobProviderModel>>(){}.getType();
    private static Type postJobType = new TypeToken<jobModel>(){}.getType();

    private static final String DB_NAME = "data_base_bitch!";
    private static final String ALL_JOBS = "all_jobs";
    private static final String PROVIDER_JOBS = "provider_jobs";
    private static final String POPULAR_JOBS = "not_for_you_man!";
    private static final String MY_APPLICATION = "list_of applications_the_service_provider_has_made";
    private static final String RESUME = "resume";
    private static final String USER = "user";
    private static final String JOB_MODEL = "job is happening";

    private static String category = "shit";

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        Utils.category = category;
    }

    public static void initialiseData(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);
        ArrayList<PopularFieldsModel> popularModels = gson.fromJson(sharedPreferences.getString(POPULAR_JOBS, null),popularType);
        ArrayList<jobProviderModel> jobProviderModels = gson.fromJson(sharedPreferences.getString(PROVIDER_JOBS, null),jobProviderType);
        resumeModel model = gson.fromJson(sharedPreferences.getString(RESUME , null), resumeModelType);
        UserModel user = gson.fromJson(sharedPreferences.getString(USER, null), userType);
        jobModel jobModel = gson.fromJson(sharedPreferences.getString(JOB_MODEL, null), postJobType);

        if (jobModel == null) {
            jobModel = new jobModel();
        }

        if (jobProviderModels == null) {
            initAllProviderJobs(context);
        }

        if (user == null) {
            user = new UserModel("none", "none","none");
        }

        if (allJobs == null){
            initAllJobs(context);
        }

        if (popularModels == null){
            initPopularJobs(context);
        }

        if (model == null) {
            model = new resumeModel("none", "none" , "none", "none");
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JOB_MODEL, gson.toJson(jobModel));
        editor.putString(USER, gson.toJson(user));
        editor.putString(RESUME, gson.toJson(model));
        editor.commit();

    }

    public static jobModel getPostedJob(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        jobModel user = gson.fromJson(sharedPreferences.getString(JOB_MODEL, null), postJobType);
        return user;
    }

    public static void setPostedJob(Context context, jobModel model) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(JOB_MODEL, gson.toJson(model));
        editor.commit();

    }

    public static UserModel getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        UserModel user = gson.fromJson(sharedPreferences.getString(USER, null), userType);
        return user;
    }

    public static void setUser(Context context, UserModel model) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER, gson.toJson(model));
        editor.commit();
    }

    public static ArrayList<PopularFieldsModel> getAllPopularFields(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        return gson.fromJson(sharedPreferences.getString(POPULAR_JOBS, null),popularType);
    }

    public static ArrayList<jobModel> getAllJobs(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        return gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);
    }

    private static void initAllProviderJobs(Context context) {
        ArrayList<jobProviderModel> providerModels = new ArrayList<>();

        ArrayList<String> skills1 = new ArrayList<>();
        skills1.add("Android Native");
        skills1.add("Java");

        jobProviderModel model1 = new jobProviderModel("Olesia gorshklo","3.4", "https://github.com/scamArtist-pro",
                "I am good at making apps.");
        model1.setpSkills(skills1);
        providerModels.add(model1);

        ArrayList<String> skills2 = new ArrayList<>();
        skills2.add("IOS Native");
        skills2.add("Swift");

        jobProviderModel model2 = new jobProviderModel("Akhil White","3.4", "https://github.com/scamArtist-pro",
                "I am good at making apps.");
        model2.setpSkills(skills2);
        providerModels.add(model2);

        ArrayList<String> skills3 = new ArrayList<>();
        skills3.add("Web Development");
        skills3.add("Java");

        jobProviderModel model3 = new jobProviderModel("Akhil black","2.3", "https://github.com/scamArtist-pro",
                "I am good at making apps.");
        model3.setpSkills(skills3);
        providerModels.add(model3);

        ArrayList<String> skills4 = new ArrayList<>();
        skills4.add("React Native");
        skills4.add("JavaScript");

        jobProviderModel model4 = new jobProviderModel("Umar javaid","5.0", "https://github.com/scamArtist-pro",
                "I am good at making apps.");
        model4.setpSkills(skills4);
        providerModels.add(model4);

        ArrayList<String> skills5 = new ArrayList<>();
        skills5.add("Word Press");
        skills5.add("JavaScript");

        jobProviderModel model5 = new jobProviderModel("dengai gorshklo","3.2", "https://github.com/scamArtist-pro",
                "I am good at making apps.");
        model5.setpSkills(skills5);
        providerModels.add(model5);

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PROVIDER_JOBS, gson.toJson(providerModels));
        editor.commit();

    }

    private static void initPopularJobs(Context context){
        ArrayList<PopularFieldsModel> popularFieldsModels = new ArrayList<>();


        PopularFieldsModel model2 = new PopularFieldsModel("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/android-512.png",
                "Android Native");

        popularFieldsModels.add(model2);

        PopularFieldsModel model3 = new PopularFieldsModel("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1200px-React-icon.svg.png",
                "React Native");

        popularFieldsModels.add(model3);

        PopularFieldsModel model4 = new PopularFieldsModel("https://www.andreasnesheim.no/wp-content/uploads/2019/05/logo_flutter_1080px_clr.png",
                "Flutter");

        popularFieldsModels.add(model4);

        PopularFieldsModel model1 = new PopularFieldsModel("https://webratna.com/wp-content/uploads/2018/02/web-development-vadodara.png",
                "Web Development");

        popularFieldsModels.add(model1);

        PopularFieldsModel model5 = new PopularFieldsModel("https://cdn3.iconfinder.com/data/icons/flat-icons-web/40/WordPress-512.png",
                "Word Press");

        popularFieldsModels.add(model5);

        PopularFieldsModel model6 = new PopularFieldsModel("https://www.arihantwebtech.com/images/design-notice/content-writing-services.png",
                "Content Writing");

        popularFieldsModels.add(model6);

        PopularFieldsModel model7 = new PopularFieldsModel("https://terraine.com/wp-content/uploads/2018/09/logo-ios.png",
                "IOS Native");

        popularFieldsModels.add(model7);

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(POPULAR_JOBS, gson.toJson(popularFieldsModels));
        editor.commit();
    }

    private static void initAllJobs(Context context) {

        ArrayList<jobModel> allJobs = new ArrayList<>();

        ArrayList<String> skills = new ArrayList<>();
        skills.add("Android");
        skills.add("Java");
        skills.add("Spring");

        ArrayList<String> perks = new ArrayList<>();
        perks.add("chocolate everyday");
        perks.add("vacation coupons");
        perks.add("free cremation on dying");

        jobModel job1 = new jobModel("Antino Labs Private Limited", "Android Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "2000", "4", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills,
                5, perks);
        job1.setStatus("In-Touch!");

        allJobs.add(job1);

        ArrayList<String> skills2 = new ArrayList<>();
        skills2.add("Android");
        skills2.add("Kotlin");

        ArrayList<String> perks2 = new ArrayList<>();
        perks2.add("vacation coupons");
        perks2.add("holidays");
        perks2.add("free cremation on dying");

        jobModel job2 = new jobModel("Excelli", "Android Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "20000", "5", "work from home", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills2,
                1, perks2);
        job2.setStatus("In-Touch!");

        allJobs.add(job2);

        ArrayList<String> skills3 = new ArrayList<>();
        skills3.add("Android");
        skills3.add("Java");
        skills3.add("Firebase");

        ArrayList<String> perks3 = new ArrayList<>();
        perks3.add("chocolate everyday");
        perks3.add("vacation coupons");
        perks3.add("holidays");

        jobModel job3 = new jobModel("Ultish Technology", "Android Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "40000", "14", "work from home", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills3,
                2, perks3);
        job3.setStatus("Not Selected!");

        allJobs.add(job3);

        ArrayList<String> skills4 = new ArrayList<>();
        skills4.add("Flutter");
        skills4.add("Dart");
        skills4.add("Android");

        ArrayList<String> perks4= new ArrayList<>();
        perks4.add("chocolate everyday");
        perks4.add("vacation coupons");
        perks4.add("free cremation on dying");

        jobModel job4 = new jobModel("Tomato Tech", "Flutter",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "5000", "3", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills4,
                3, perks4);
        job4.setStatus("Selected!");

        allJobs.add(job4);

        ArrayList<String> skills5 = new ArrayList<>();
        skills5.add("Android");
        skills5.add("IOS");
        skills5.add("Flutter");
        skills5.add("UI/UX design");

        ArrayList<String> perks5 = new ArrayList<>();
        perks5.add("chocolate everyday");
        perks5.add("vacation coupons");
        perks5.add("holidays");
        perks5.add("free cremation on dying");
        perks5.add("Certificate");
        perks5.add("Extra money on good work");

        jobModel job5 = new jobModel("Mobile Smart", "Flutter",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "6000", "5", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills5,
                15, perks5);
        job5.setStatus("In-Touch!");

        allJobs.add(job5);

        ArrayList<String> skills6 = new ArrayList<>();
        skills6.add("JavaScript");
        skills6.add("React Native");
        skills6.add("HTML/CSS");

        ArrayList<String> perks6 = new ArrayList<>();
        perks6.add("You get 10 min breaks everyday");
        perks6.add("Certificate");
        perks6.add("Extra money on good work");

        jobModel job6 = new jobModel("Iraitech Limited", "React Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "6000", "5", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills6,
                8, perks6);
        job6.setStatus("Reviewing your application!");

        allJobs.add(job6);

        ArrayList<String> skills7 = new ArrayList<>();
        skills7.add("JavaScript");
        skills7.add("React Native");
        skills7.add("Adobe XD");
        skills7.add("HTML/CSS");

        ArrayList<String> perks7 = new ArrayList<>();
        perks7.add("You get 10 min breaks everyday");
        perks7.add("Don't expect much");
        perks7.add("Certificate");
        perks7.add("Extra money on good work");

        jobModel job7 = new jobModel("Lol Limited", "React Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "6300", "2", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills7,
                9, perks7);
        job7.setStatus("Selected!");

        allJobs.add(job7);

        ArrayList<String> skills8 = new ArrayList<>();
        skills8.add("JavaScript");
        skills8.add("Angular");
        skills8.add("Figma");
        skills8.add("HTML/CSS");

        ArrayList<String> perks8 = new ArrayList<>();
        perks8.add("You get 10 min breaks everyday");
        perks8.add("Certificate");
        perks8.add("One fruti");
        perks8.add("Extra money on good work");

        jobModel job8 = new jobModel("Hi-life Tech Limited", "Web Development",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "4000", "5", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills8,
                11, perks8);
        job8.setStatus("In-Touch!");

        allJobs.add(job8);

        ArrayList<String> skills9 = new ArrayList<>();
        skills9.add("Content writing");
        skills9.add("Word Press");
        skills9.add("bootstrap");
        skills9.add("HTML/CSS");

        ArrayList<String> perks9 = new ArrayList<>();
        perks9.add("Certificate");
        perks9.add("One fruti");
        perks9.add("You get 10 min breaks everyday");

        jobModel job9 = new jobModel("Wagoti Private Limited", "Word Press",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "6560", "5", "work from office", "Job",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills9,
                11, perks9);
        job9.setStatus("In-Touch!");

        allJobs.add(job9);

        ArrayList<String> skills10 = new ArrayList<>();
        skills10.add("Content Writing");
        skills10.add("English proficiency");
        skills10.add("min 60wpm");

        ArrayList<String> perks10 = new ArrayList<>();
        perks10.add("Certificate");
        perks10.add("Work in a AC room");
        perks10.add("You get 10 min breaks everyday");

        jobModel job10 = new jobModel("Google Private Tech Limited", "Content Writing",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "3000", "1", "work from home", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills10,
                1, perks10);
        job10.setStatus("In-Touch!");

        allJobs.add(job10);

        ArrayList<String> skill = new ArrayList<>();
        skill.add("IOS");
        skill.add("XCode");
        skill.add("Swift");

        ArrayList<String> perk = new ArrayList<>();
        perk.add("Certificate");
        perk.add("Work in a AC room");
        perk.add("Work in apple factory for a day");
        perk.add("You get 10 min breaks everyday");

        jobModel job = new jobModel("Google Private Tech Limited", "IOS Native",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "30000", "8", "work from home", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skill,
                6, perk);
        job.setStatus("In-Touch!");

        allJobs.add(job);

        ArrayList<String> skills11 = new ArrayList<>();
        skills11.add("Objective-C");
        skills11.add("XCode");
        skill.add("IOS");

        ArrayList<String> perks11 = new ArrayList<>();
        perks11.add("Certificate");
        perks11.add("Work in a AC room");
        perks11.add("You get 10 min breaks everyday");

        jobModel job11 = new jobModel("micro-Apple Private Limited", "IOS NATIVE",
                "https://www.it-corner.net/wp-content/uploads/2018/07/Slider-Mobile-App-Development-450x386.png",
                "30000", "2", "work from office", "Internship",
                "this is a good company and i hope you as my servent will enjoy it more than us.",
                "this is job is not for the week minded idiots and quiers die tomorrow or die today quier", skills11,
                10, perks11);
        job11.setStatus("Not Selected!");

        allJobs.add(job11);

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALL_JOBS, gson.toJson(allJobs));
        editor.commit();

    }

    public static void updatePopularFields(Context context, ArrayList<String> model) {
        ArrayList<PopularFieldsModel> popularModels = Utils.getAllPopularFields(context);

        ArrayList<PopularFieldsModel> popularFieldsModels = new ArrayList<>();

        for (String m: model) {
            for (PopularFieldsModel p: popularModels) {
                if (m.equalsIgnoreCase(p.getFieldName())){
                    popularFieldsModels.add(p);
                }
            }
        }

        for (PopularFieldsModel p: popularModels) {
            boolean exists = false;
            for (PopularFieldsModel l: popularFieldsModels){
                if (p.getFieldName().equalsIgnoreCase(l.getFieldName())){
                    exists = true;
                }
            }

            if (!exists) {
                popularFieldsModels.add(p);
            }
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(POPULAR_JOBS, gson.toJson(popularFieldsModels));
        editor.commit();

    }

    public static void updateJobs(Context context, ArrayList<String> model) {
        ArrayList<jobModel> popularModels = Utils.getAllJobs(context);

        ArrayList<jobModel> popularFieldsModels = new ArrayList<>();

        for (String m: model) {
            for (jobModel p: popularModels) {
                if (m.equalsIgnoreCase(p.getCategory())){
                    popularFieldsModels.add(p);
                }
            }
        }

        for (jobModel p: popularModels) {
            boolean exists = false;
            for (jobModel l: popularFieldsModels){
                if (p.getId() == l.getId()){
                    exists = true;
                }
            }

            if (!exists) {
                popularFieldsModels.add(p);
            }
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ALL_JOBS, gson.toJson(popularFieldsModels));
        editor.commit();

    }

    public static void addApplications(Context context, jobModel model) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allApplications = gson.fromJson(sharedPreferences.getString(MY_APPLICATION, null), jobType);

        if (allApplications == null){
            allApplications = new ArrayList<>();
            allApplications.add(model);
        }

        boolean exits = false;

        for (jobModel j: allApplications) {
            if (j.getId() == model.getId()){
                exits = true;
            }
        }

        if (!exits) {
            allApplications.add(model);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_APPLICATION, gson.toJson(allApplications));
        editor.commit();

    }

    public static ArrayList<jobProviderModel> getProvider(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobProviderModel> models = gson.fromJson(sharedPreferences.getString(PROVIDER_JOBS, null), jobProviderType);
        return models;
    }

    public static ArrayList<jobModel> getAllApplications(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allApplications = gson.fromJson(sharedPreferences.getString(MY_APPLICATION, null), jobType);
        return allApplications;
    }


    public static void addResume(Context context, resumeModel resumeModel) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        resumeModel model = gson.fromJson(sharedPreferences.getString(RESUME , null), resumeModelType);


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RESUME, gson.toJson(resumeModel));
        editor.commit();
    }

    public static resumeModel getResume(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        resumeModel model = gson.fromJson(sharedPreferences.getString(RESUME , null), resumeModelType);
        return model;
    }

    public static ArrayList<jobModel> searchItem(Context context, String text) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);

        if (allJobs != null) {
            ArrayList<jobModel> newList = new ArrayList<>();
            for (jobModel j: allJobs) {
                if (j.getCompanyTitle().equals(text)) {
                    newList.add(j);
                }

                String[] name = j.getCompanyTitle().split(" ");
                for (int i=0; i<name.length; i++) {
                    if (text.equalsIgnoreCase(name[i])){

                        boolean exists = false;
                        for (jobModel k: newList) {
                            if (k.getId() == j.getId()) {
                                exists = true;
                            }
                        }

                        if (!exists) {
                            newList.add(j);
                        }

                    }
                }
            }

            return newList;
        }

        return null;
    }

    public static ArrayList<jobModel> searchWithCategory(Context context, String text) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);

        if (allJobs != null) {
            ArrayList<jobModel> newList = new ArrayList<>();
            for (jobModel j: allJobs) {
                if (j.getCategory().equals(text)) {
                    newList.add(j);
                }

            }

            return newList;
        }

        return null;
    }

    public static void saveJob(Context context, int id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);

        if (allJobs != null) {
            ArrayList<jobModel> newJobs = new ArrayList<>();
            for (jobModel j: allJobs) {
                if (j.getId() == id) {
                    j.setSaved(true);
                    newJobs.add(j);
                }else {
                    newJobs.add(j);
                }
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(ALL_JOBS, gson.toJson(newJobs));
            editor.commit();
        }
    }

    public static void unSaveJob(Context context, int id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);

        if (allJobs != null) {

            ArrayList<jobModel> newJobs = new ArrayList<>();
            for (jobModel j: allJobs) {
                if (j.getId() == id) {
                    j.setSaved(false);
                    newJobs.add(j);
                }else {
                    newJobs.add(j);
                }
            }

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(ALL_JOBS, gson.toJson(newJobs));
            editor.commit();
        }
    }

    public static boolean verifySaved(Context context, jobModel job) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);
        boolean exists = false;

        for (jobModel j: allJobs) {
            if (j.getId() == job.getId()) {
                if (j.isSaved()) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    public static ArrayList<jobModel> getSavedJobs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        ArrayList<jobModel> allJobs = gson.fromJson(sharedPreferences.getString(ALL_JOBS, null), jobType);

        if (allJobs != null) {
            ArrayList<jobModel> getJobs = new ArrayList<>();
            for (jobModel j: allJobs) {
                if (j.isSaved()) {
                    getJobs.add(j);
                }
            }

            return getJobs;
        }
        return null;
    }

    public static void clearSharedPreferences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static int getId() {
        ID++;
        return ID;
    }

    public static int getPopular_ID() {
        Popular_ID++;
        return Popular_ID;
    }

    public static int getProvider_ID() {
        Provider_ID++;
        return Provider_ID;
    }

}
