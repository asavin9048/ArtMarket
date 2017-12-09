package asavin.mvp;

import android.app.Application;
import android.preference.PreferenceManager;

import org.greenrobot.greendao.database.Database;

import asavin.mvp.model.dao.DaoMaster;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.entity.Frame.Frame;
import asavin.mvp.model.entity.brand.Brand;
import asavin.mvp.model.entity.child.Coloring;
import asavin.mvp.model.entity.child.Feltpen;
import asavin.mvp.model.entity.child.Puzzle;
import asavin.mvp.model.entity.child.School;
import asavin.mvp.model.entity.child.Toy;
import asavin.mvp.model.entity.guide.Guide;
import asavin.mvp.model.entity.hobbie.Burning;
import asavin.mvp.model.entity.hobbie.Decorating;
import asavin.mvp.model.entity.hobbie.Decoupage;
import asavin.mvp.model.entity.hobbie.Gilding;
import asavin.mvp.model.entity.hobbie.Quilling;
import asavin.mvp.model.entity.hobbie.Wallow;
import asavin.mvp.model.entity.painting.*;
import asavin.mvp.model.entity.sculpture.Sculptinside;
import asavin.mvp.model.entity.sculpture.Thread;

public class App extends Application {
    private DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();



//        Brand brand1 = new Brand("brand1","akryl");
//        Brand brand2 = new Brand("brand2","akryl");
//        daoSession.getBrandDao().insert(brand1);
//        daoSession.getBrandDao().insert(brand2);
//
//        Paint paint1 = new Paint("qq","guache",brand1.getId(),new Long(7));
//        Paint paint2 = new Paint("dd","akryl",brand2.getId());
//
//
//        daoSession.getPaintDao().insert(paint1);
//        daoSession.getPaintDao().insert(paint2);



        if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("firstRun",true)){//при первом запуске приложения
            PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("firstRun",false).apply();



            Brand rosaStudio = new Brand("ROSA","ROSA - ведущий украинский производитель профессиональных\n" +
                    "материалов для живописи, товаров для хобби и декора, создатель креативных\n" +
                    "наборов для творчества для новичков, которые хотят присоединиться к\n" +
                    "искусству. Наша история - 20 лет опыта производства художественных\n" +
                    "материалов.\n" +
                    "Продуктами бренда ROSA пользуются художники Украины, а также\n" +
                    "художники из многих уголков мира, так как уже более 15 лет мы\n" +
                    "экспортируем их в Болгарю, Великобританию, Армению, Грецию, Грузию,\n" +
                    "Эстонию, Казахстан, Молдову, Германию, Норвегию, Россию, Румынию,\n" +
                    "Словакию, Словению, США, Францию.\n" +
                    "Для создания и совершенствования продуктов мы изучаем потребности\n" +
                    "потребителей, обратную связь от наших партнеров, тенденции рынка,\n" +
                    "принимаем участие в мировых и отечественных выставках.","unknown");


            daoSession.getBrandDao().insert(rosaStudio);


            /*Canvas canvas = new Canvas*/
            getDaoSession().getCanvasDao().insert(new Canvas("ДВП негрунтованное ROSA Studio. 13x18 см.", "dvp_negruntovanoe", rosaStudio.getId(), (long) 3.20));

            Canvas canvas2 = new Canvas
                    ("ДВП грунтованное ROSA Studio акрил. 13x18 см.","dvp_gruntovanoe",rosaStudio.getId(), (long) 3.40);

//            Canvas canvas3 = new Canvas
            getDaoSession().getCanvasDao().insert(new Canvas("Картон грунтованный ROSA Studio набор 5 шт. 10х10 см.","c2_1_2",rosaStudio.getId(), (long) 4.15));
 ;

            /*Paint paint = */getDaoSession().getPaintDao().insert(new Paint("Краска гуашевая 40мл ROSA Studio 20 цветов","p6_1",rosaStudio.getId(), (long) 300));
            /*Paint paint2 =*/ getDaoSession().getPaintDao().insert(new Paint("Зеленая темная акрил Сонет 120 мл","",rosaStudio.getId(), (long) 79.20));


//            Pencil pencil =
                    getDaoSession().getPencilDao().insert(new Pencil("Чернильные карандаши Inktense 12цв Derwent","",rosaStudio.getId(), (long) 497.60));
//            Pencil pencil2 =
            getDaoSession().getPencilDao().insert(new Pencil("Цветные карандаши EXPRESSION 36цв Bruynzeel","",rosaStudio.getId(), (long) 497.60));

//            Pencil pencil3 =
            getDaoSession().getPencilDao().insert(new Pencil("Пастельные карандаши Fine Art 24цв Cretacolor","",rosaStudio.getId(), (long) 1100));

//            Paper paper =
                    daoSession.getPaperDao().insert(new Paper("Картон переплетный Мастер Класc 800х1000мм 2мм коричневий\n" +
                    "42,65 грн..","",rosaStudio.getId(), (long) 12.25));
//            Paper paper2 =
            daoSession.getPaperDao().insert(new Paper("Картон для акрила Нескучный вечер 35х50см 5 листов\n" +
                    "330г/м2","",rosaStudio.getId(), (long) 385));
//            Paper paper3 =
                    daoSession.getPaperDao().insert(new Paper("Альбом для пастели Aquamarinе 160г/м2 54л А4 257","",rosaStudio.getId(), (long) 257));

//            Brush brush1 =
                    daoSession.getBrushDao().insert(new Brush("Пони круглая 612 короткая ручка ROSA START","",rosaStudio.getId(), (long) 12));
//            Brush brush2 =
            daoSession.getBrushDao().insert(new Brush("Щетина овальная Grace 2023FR длинная KOLOS №10","",rosaStudio.getId(), (long) 96));
//            Brush brush3 =
            daoSession.getBrushDao().insert(new Brush("Мастихин ROSA START 11915 ромб","",rosaStudio.getId(), (long) 50));

//            Easel easel1 =
                    daoSession.getEaselDao().insert(new Easel("Планшет c магнитным зажимом и ремнем ROSA А3","",rosaStudio.getId(), (long) 115));
//            Easel easel2 =
                    daoSession.getEaselDao().insert(new Easel("Планшет с магнитным зажимом МДФ ROSA 53х63 см.","",rosaStudio.getId(), (long) 109));
//            Easel easel3 =
            daoSession.getEaselDao().insert(new Easel("Мольберт-хлопушка настольный ROSA Talent  22х23х38см.","",rosaStudio.getId(), (long) 134));


            daoSession.getWallowDao().insert(new Wallow("Фетр листовой полиэстер 20х30см 150 г/м2 голубой","",rosaStudio.getId(), (long) 14.55));
            daoSession.getWallowDao().insert(new Wallow("Фетр полиэстер набор 6 цветов 21,5х28 см 180г/м2","",rosaStudio.getId(), (long) 150));
            daoSession.getWallowDao().insert(new Wallow("Шерсть для валяния кардочесанная 10г красная","",rosaStudio.getId(), (long) 30));


            daoSession.getBurningDao().insert(new Burning("Выжигатель по дереву художественный ROSA TALENT 5 насадок","",rosaStudio.getId(), (long) 315));
            daoSession.getBurningDao().insert(new Burning("Мини-заготовки Листья фанера 10шт ROSA TALENT","",rosaStudio.getId(), (long) 37.50));

            daoSession.getDecoratingDao().insert(new Decorating("Наклейка Цветочные рамки JEJE","",rosaStudio.getId(), (long) 9.10));
            daoSession.getDecoratingDao().insert(new Decorating("Наклейка Листья серебренная JEJE","",rosaStudio.getId(), (long) 15.40));

            daoSession.getDecoupageDao().insert(new Decoupage("Акрил для декора перламутровый 20мл ROSA Studio золото","",rosaStudio.getId(), (long) 25));
            daoSession.getDecoupageDao().insert(new Decoupage("Набор спонжей поролоновых ширина 25мм 12шт","",rosaStudio.getId(), (long) 53.20));

            daoSession.getQuillingDao().insert(new Quilling("Набор материалов для квилинга Микс 280полосок, 34,5см, 130г/м2,\n" +
                    "трафарет, шпильки, инструмент, Folia","",rosaStudio.getId(), (long) 280));

            daoSession.getGildingDao().insert(new Gilding("Разбавитель для шеллака 250мл Renesans","",rosaStudio.getId(), (long) 114.20));

            daoSession.getFeltpenDao().insert(new Feltpen("Маркер перманентный Schneider MAXX 133 черный","",rosaStudio.getId(), (long) 19));
            daoSession.getFeltpenDao().insert(new Feltpen("Набор маркеров для белых досок Economix 4 шт","",rosaStudio.getId(), (long) 36));

            daoSession.getToyDao().insert(new Toy("Набор разрисуй игрушку &quot;Слонёнок&quot; ROSA KIDS","",rosaStudio.getId(), (long) 114));
            daoSession.getToyDao().insert(new Toy("Набор лисенок Смайли ROSA KIDS","",rosaStudio.getId(), (long) 158));

            daoSession.getPuzzleDao().insert(new Puzzle("3D пазл Черепаха морская фанерная","",rosaStudio.getId(), (long) 100));
            daoSession.getPuzzleDao().insert(new Puzzle("ПАЗЛЫ РАЗНОЦВЕТНАЯ АФРИКА 1500 Ravernsburger","",rosaStudio.getId(), (long) 450));

            daoSession.getColoringDao().insert(new Coloring("Набор,Малювалка, Медвеженок на прогулке, ROSA KIDS","",rosaStudio.getId(), (long) 138));

            daoSession.getSchoolDao().insert(new School("Папка для тетрадей пластиковая «Frozen» 1 Вересня","",rosaStudio.getId(), (long) 66));

            daoSession.getFrameDao().insert(new Frame("Антирама А4 (21х30) задняя стенка ДВП антибликовое стекло","",rosaStudio.getId(), (long) 75));

            daoSession.getSculptinsideDao().insert(new Sculptinside("Пластилин Скульптурный, 400г телесный","",rosaStudio.getId(), (long) 44.45));

//            Thread thread =
                   daoSession.getThreadDao().insert(new Thread("Фольга ESSDEE HFB Голография","",rosaStudio.getId(), (long) 3.05));

            Guide guide = new Guide("Some","animal","https://www.youtube.com/watch?v=LKK2qgvsuDU");

            getDaoSession().getGuideDao().insert(guide);


//            Guide



//            Brand brand1 = new Brand("brand1","akryl");
//            Brand brand2 = new Brand("brand2","akryl");
//            daoSession.getBrandDao().insert(brand1);
//            daoSession.getBrandDao().insert(brand2);
//
//            Paint paint1 = new Paint("guach","guache",brand1.getId());
//            Paint paint2 = new Paint("akryl","akryl",brand2.getId());
//
//            daoSession.getPaintDao().insert(paint1);
//            daoSession.getPaintDao().insert(paint2);


//            Log.d("db"," crated");
//            Feltpen feltPen = new Feltpen();
//            feltPen.setId(5);
//            feltPen.setName("nameee");
////            note.setText(noteText);
////            note.setComment(comment);
////            note.setDate(new Date());
////            note.setType(NoteType.TEXT);
//            FeltPenDao dao = daoSession.getFeltPenDao();
//            dao.insert(feltPen);
//            daoSession.insertOrReplace(feltPen);
//
//            Guide yoy = new Guide(1,"lolol");
//
//            Log.d("sww",""+daoSession.loadAll(Feltpen.class).size());
////            Log.d("DaoExample", "Inserted new note, ID: " + note.getId());


//            daoSession.getFeltpenDao().insert(new Feltpen("f1","lo"));
//            daoSession.getFeltpenDao().insert(new Feltpen("f2","ho"));
//            BucketUtil.getBucket().addToBucket(1,"Feltpen",this);
//            BucketUtil.getBucket().addToBucket(2,"Feltpen",this);

        }


//        Sculptinside s1 = new Sculptinside("s1","ll");
//        daoSession.getSculptinsideDao().insert(s1);
//        BucketUtil.getBucket().addToBucket(s1.getId(),"Sculptinside",this);
//        Feltpen f1 = new Feltpen("f1","lo");
//        Feltpen f2 = new Feltpen("f2","lo");
//        daoSession.getFeltpenDao().insert(f1);
//        daoSession.getFeltpenDao().insert(f2);
//        BucketUtil.getBucket().addToBucket(f1.getId(),"Feltpen",this);
//        BucketUtil.getBucket().addToBucket(f2.getId(),"Feltpen",this);
//        daoSession.getFeltPenDao().insert(new Feltpen("nnn"));

//        daoSession.getDatabase().

//        for(Feltpen pen:daoSession.getFeltPenDao().loadAll()){
//            Log.d("fid",""+pen.getId()+pen.getName()+" "+pen.getImageResource());
//        }
//        daoSession.getToyDao().insert(new Guide(1,"lolol"));
//        BucketUtil.getBucket().addToBucket(1,"Guide",this);
//
//        BucketUtil.getBucket().addToBucket(1,"Feltpen",this);
//        BucketUtil.getBucket().addToBucket(2,"Feltpen",this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
