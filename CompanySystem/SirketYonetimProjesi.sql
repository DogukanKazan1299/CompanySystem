PGDMP         2                x            SirketYonetimProjesi    10.10    10.10 W    Y           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            Z           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            [           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            \           1262    41935    SirketYonetimProjesi    DATABASE     ?   CREATE DATABASE "SirketYonetimProjesi" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Turkish_Turkey.1254' LC_CTYPE = 'Turkish_Turkey.1254';
 &   DROP DATABASE "SirketYonetimProjesi";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ]           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ^           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1255    50269    netkarzarar_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.netkarzarar_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
NEW.netkarzarar = NEW.toplamgelir - (NEW.toplammaas + NEW.digergiderler);
return NEW;
end
$$;
 /   DROP FUNCTION public.netkarzarar_fonksiyonu();
       public       postgres    false    1    3            ?            1255    50274    toplamisartirma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplamisartirma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamis = toplamis + 1;
return NEW;
end
$$;
 3   DROP FUNCTION public.toplamisartirma_fonksiyonu();
       public       postgres    false    1    3            ?            1255    50282    toplamisazaltma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplamisazaltma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamis = toplamis - 1;
return old;
end
$$;
 3   DROP FUNCTION public.toplamisazaltma_fonksiyonu();
       public       postgres    false    1    3            ?            1255    50581    toplamisgeliri_fonksiyonu()    FUNCTION     A  CREATE FUNCTION public.toplamisgeliri_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
--new.toplamisgeliri := new.isgeliri + toplamisgeliri;

--Update isler set toplamisgeliri = new.isgeliri + new.toplamisgeliri;
Update raporlar set toplamgelir = new.isgeliri + new.digergelirler;

return new;
end
$$;
 2   DROP FUNCTION public.toplamisgeliri_fonksiyonu();
       public       postgres    false    3    1            ?            1255    50299 "   toplampersonelartirma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplampersonelartirma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamcalisan = toplamcalisan + 1;
return new;
end
$$;
 9   DROP FUNCTION public.toplampersonelartirma_fonksiyonu();
       public       postgres    false    3    1            ?            1255    50286 "   toplampersonelazaltma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplampersonelazaltma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamcalisan = toplamcalisan - 1;
return old;
end
$$;
 9   DROP FUNCTION public.toplampersonelazaltma_fonksiyonu();
       public       postgres    false    3    1            ?            1255    50301 "   toplamyoneticiartirma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplamyoneticiartirma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamcalisan = toplamcalisan + 1;
return new;
end
$$;
 9   DROP FUNCTION public.toplamyoneticiartirma_fonksiyonu();
       public       postgres    false    1    3            ?            1255    50288 "   toplamyoneticiazaltma_fonksiyonu()    FUNCTION     ?   CREATE FUNCTION public.toplamyoneticiazaltma_fonksiyonu() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
Begin 
Update raporlar set toplamcalisan = toplamcalisan - 1;
return old;
end
$$;
 9   DROP FUNCTION public.toplamyoneticiazaltma_fonksiyonu();
       public       postgres    false    1    3            ?            1259    41975 
   calisanlar    TABLE     ?   CREATE TABLE public.calisanlar (
    id integer NOT NULL,
    ad_soyad character varying(30),
    departman character varying(25),
    giristarihi date,
    sozlesmesuresi real,
    sirketid integer
);
    DROP TABLE public.calisanlar;
       public         postgres    false    3            ?            1259    41973    calisanlar_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.calisanlar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.calisanlar_id_seq;
       public       postgres    false    201    3            _           0    0    calisanlar_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.calisanlar_id_seq OWNED BY public.calisanlar.id;
            public       postgres    false    200            ?            1259    50464    calisanlarisyapar    TABLE     ?   CREATE TABLE public.calisanlarisyapar (
    yoneticiid integer,
    personelid integer,
    yapildigitarih date,
    isid integer
);
 %   DROP TABLE public.calisanlarisyapar;
       public         postgres    false    3            ?            1259    42043    depo    TABLE     ?   CREATE TABLE public.depo (
    id integer NOT NULL,
    urunadi character varying(25),
    urunozelligi character varying(25),
    adeti integer,
    sirketid integer
);
    DROP TABLE public.depo;
       public         postgres    false    3            ?            1259    42041    depo_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.depo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.depo_id_seq;
       public       postgres    false    3    207            `           0    0    depo_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.depo_id_seq OWNED BY public.depo.id;
            public       postgres    false    206            ?            1259    50454    isler    TABLE       CREATE TABLE public.isler (
    id integer NOT NULL,
    isadi character varying(50),
    isalani character varying(50),
    isyapilanfirma character varying(50),
    sozlesmesuresi real,
    isgeliri integer,
    digergelirler integer,
    sirketid integer
);
    DROP TABLE public.isler;
       public         postgres    false    3            ?            1259    41962 	   kullanici    TABLE     ?   CREATE TABLE public.kullanici (
    id integer NOT NULL,
    kullaniciadi character varying(25),
    parola character varying(25),
    sirketid integer
);
    DROP TABLE public.kullanici;
       public         postgres    false    3            ?            1259    41960    kullanici_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kullanici_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.kullanici_id_seq;
       public       postgres    false    3    199            a           0    0    kullanici_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.kullanici_id_seq OWNED BY public.kullanici.id;
            public       postgres    false    198            ?            1259    66637    patron    TABLE     c   CREATE TABLE public.patron (
    id integer NOT NULL,
    bilgi character varying(200) NOT NULL
);
    DROP TABLE public.patron;
       public         postgres    false    3            ?            1259    66635    patron_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.patron_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.patron_id_seq;
       public       postgres    false    211    3            b           0    0    patron_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.patron_id_seq OWNED BY public.patron.id;
            public       postgres    false    210            ?            1259    41998    personel    TABLE     R   CREATE TABLE public.personel (
    p_maas integer
)
INHERITS (public.calisanlar);
    DROP TABLE public.personel;
       public         postgres    false    3    201            ?            1259    42030    raporlar    TABLE     ?   CREATE TABLE public.raporlar (
    id integer NOT NULL,
    toplamcalisan integer,
    toplamis integer,
    toplammaas integer,
    toplamgelir integer,
    digergiderler integer,
    netkarzarar integer,
    sirketid integer
);
    DROP TABLE public.raporlar;
       public         postgres    false    3            ?            1259    42028    raporlar_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.raporlar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.raporlar_id_seq;
       public       postgres    false    3    205            c           0    0    raporlar_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.raporlar_id_seq OWNED BY public.raporlar.id;
            public       postgres    false    204            ?            1259    41938    sirket    TABLE     V   CREATE TABLE public.sirket (
    id integer NOT NULL,
    ad character varying(25)
);
    DROP TABLE public.sirket;
       public         postgres    false    3            ?            1259    41936    sirket_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.sirket_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.sirket_id_seq;
       public       postgres    false    197    3            d           0    0    sirket_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.sirket_id_seq OWNED BY public.sirket.id;
            public       postgres    false    196            ?            1259    41994    yonetici    TABLE     R   CREATE TABLE public.yonetici (
    y_maas integer
)
INHERITS (public.calisanlar);
    DROP TABLE public.yonetici;
       public         postgres    false    3    201            ?
           2604    41978    calisanlar id    DEFAULT     n   ALTER TABLE ONLY public.calisanlar ALTER COLUMN id SET DEFAULT nextval('public.calisanlar_id_seq'::regclass);
 <   ALTER TABLE public.calisanlar ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    200    201            ?
           2604    42046    depo id    DEFAULT     b   ALTER TABLE ONLY public.depo ALTER COLUMN id SET DEFAULT nextval('public.depo_id_seq'::regclass);
 6   ALTER TABLE public.depo ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    206    207    207            ?
           2604    41965    kullanici id    DEFAULT     l   ALTER TABLE ONLY public.kullanici ALTER COLUMN id SET DEFAULT nextval('public.kullanici_id_seq'::regclass);
 ;   ALTER TABLE public.kullanici ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            ?
           2604    66640 	   patron id    DEFAULT     f   ALTER TABLE ONLY public.patron ALTER COLUMN id SET DEFAULT nextval('public.patron_id_seq'::regclass);
 8   ALTER TABLE public.patron ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    211    210    211            ?
           2604    42001    personel id    DEFAULT     l   ALTER TABLE ONLY public.personel ALTER COLUMN id SET DEFAULT nextval('public.calisanlar_id_seq'::regclass);
 :   ALTER TABLE public.personel ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    200            ?
           2604    42033    raporlar id    DEFAULT     j   ALTER TABLE ONLY public.raporlar ALTER COLUMN id SET DEFAULT nextval('public.raporlar_id_seq'::regclass);
 :   ALTER TABLE public.raporlar ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    204    205            ?
           2604    41941 	   sirket id    DEFAULT     f   ALTER TABLE ONLY public.sirket ALTER COLUMN id SET DEFAULT nextval('public.sirket_id_seq'::regclass);
 8   ALTER TABLE public.sirket ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            ?
           2604    41997    yonetici id    DEFAULT     l   ALTER TABLE ONLY public.yonetici ALTER COLUMN id SET DEFAULT nextval('public.calisanlar_id_seq'::regclass);
 :   ALTER TABLE public.yonetici ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    202            L          0    41975 
   calisanlar 
   TABLE DATA               d   COPY public.calisanlar (id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid) FROM stdin;
    public       postgres    false    201   ?e       T          0    50464    calisanlarisyapar 
   TABLE DATA               Y   COPY public.calisanlarisyapar (yoneticiid, personelid, yapildigitarih, isid) FROM stdin;
    public       postgres    false    209   ?e       R          0    42043    depo 
   TABLE DATA               J   COPY public.depo (id, urunadi, urunozelligi, adeti, sirketid) FROM stdin;
    public       postgres    false    207   f       S          0    50454    isler 
   TABLE DATA               v   COPY public.isler (id, isadi, isalani, isyapilanfirma, sozlesmesuresi, isgeliri, digergelirler, sirketid) FROM stdin;
    public       postgres    false    208   ?f       J          0    41962 	   kullanici 
   TABLE DATA               G   COPY public.kullanici (id, kullaniciadi, parola, sirketid) FROM stdin;
    public       postgres    false    199   'g       V          0    66637    patron 
   TABLE DATA               +   COPY public.patron (id, bilgi) FROM stdin;
    public       postgres    false    211   ig       N          0    41998    personel 
   TABLE DATA               j   COPY public.personel (id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid, p_maas) FROM stdin;
    public       postgres    false    203   #h       P          0    42030    raporlar 
   TABLE DATA               ~   COPY public.raporlar (id, toplamcalisan, toplamis, toplammaas, toplamgelir, digergiderler, netkarzarar, sirketid) FROM stdin;
    public       postgres    false    205   ?h       H          0    41938    sirket 
   TABLE DATA               (   COPY public.sirket (id, ad) FROM stdin;
    public       postgres    false    197   ?h       M          0    41994    yonetici 
   TABLE DATA               j   COPY public.yonetici (id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid, y_maas) FROM stdin;
    public       postgres    false    202   i       e           0    0    calisanlar_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.calisanlar_id_seq', 4, true);
            public       postgres    false    200            f           0    0    depo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.depo_id_seq', 1, false);
            public       postgres    false    206            g           0    0    kullanici_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.kullanici_id_seq', 2, true);
            public       postgres    false    198            h           0    0    patron_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.patron_id_seq', 11, true);
            public       postgres    false    210            i           0    0    raporlar_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.raporlar_id_seq', 1, false);
            public       postgres    false    204            j           0    0    sirket_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.sirket_id_seq', 1, false);
            public       postgres    false    196            ?
           2606    41980    calisanlar calisanlar_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.calisanlar
    ADD CONSTRAINT calisanlar_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.calisanlar DROP CONSTRAINT calisanlar_pkey;
       public         postgres    false    201            ?
           2606    42048    depo depo_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.depo
    ADD CONSTRAINT depo_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.depo DROP CONSTRAINT depo_pkey;
       public         postgres    false    207            ?
           2606    50458    isler isler_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.isler
    ADD CONSTRAINT isler_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.isler DROP CONSTRAINT isler_pkey;
       public         postgres    false    208            ?
           2606    41967    kullanici kullanici_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.kullanici DROP CONSTRAINT kullanici_pkey;
       public         postgres    false    199            ?
           2606    66642    patron patron_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.patron
    ADD CONSTRAINT patron_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.patron DROP CONSTRAINT patron_pkey;
       public         postgres    false    211            ?
           2606    50249    personel personel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.personel
    ADD CONSTRAINT personel_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.personel DROP CONSTRAINT personel_pkey;
       public         postgres    false    203            ?
           2606    42035    raporlar raporlar_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.raporlar
    ADD CONSTRAINT raporlar_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.raporlar DROP CONSTRAINT raporlar_pkey;
       public         postgres    false    205            ?
           2606    41943    sirket sirket_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.sirket
    ADD CONSTRAINT sirket_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.sirket DROP CONSTRAINT sirket_pkey;
       public         postgres    false    197            ?
           2606    50247    yonetici yonetici_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.yonetici
    ADD CONSTRAINT yonetici_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.yonetici DROP CONSTRAINT yonetici_pkey;
       public         postgres    false    202            ?
           2620    50270    raporlar netkarzarar_trigger    TRIGGER     ?   CREATE TRIGGER netkarzarar_trigger BEFORE INSERT OR UPDATE ON public.raporlar FOR EACH ROW EXECUTE PROCEDURE public.netkarzarar_fonksiyonu();
 5   DROP TRIGGER netkarzarar_trigger ON public.raporlar;
       public       postgres    false    229    205            ?
           2620    50539    isler toplamiazaltma_trigger    TRIGGER     ?   CREATE TRIGGER toplamiazaltma_trigger BEFORE DELETE ON public.isler FOR EACH ROW EXECUTE PROCEDURE public.toplamisazaltma_fonksiyonu();
 5   DROP TRIGGER toplamiazaltma_trigger ON public.isler;
       public       postgres    false    213    208            ?
           2620    50537    isler toplamisartirma_trigger    TRIGGER     ?   CREATE TRIGGER toplamisartirma_trigger BEFORE INSERT ON public.isler FOR EACH ROW EXECUTE PROCEDURE public.toplamisartirma_fonksiyonu();
 6   DROP TRIGGER toplamisartirma_trigger ON public.isler;
       public       postgres    false    212    208            ?
           2620    50582    isler toplamisgeliri_trigger    TRIGGER     ?   CREATE TRIGGER toplamisgeliri_trigger BEFORE INSERT ON public.isler FOR EACH ROW EXECUTE PROCEDURE public.toplamisgeliri_fonksiyonu();
 5   DROP TRIGGER toplamisgeliri_trigger ON public.isler;
       public       postgres    false    208    231            ?
           2620    50287 &   personel toplampersonelazaltma_trigger    TRIGGER     ?   CREATE TRIGGER toplampersonelazaltma_trigger BEFORE DELETE ON public.personel FOR EACH ROW EXECUTE PROCEDURE public.toplampersonelazaltma_fonksiyonu();
 ?   DROP TRIGGER toplampersonelazaltma_trigger ON public.personel;
       public       postgres    false    214    203            ?
           2620    50300 $   personel toplampersoneltirma_trigger    TRIGGER     ?   CREATE TRIGGER toplampersoneltirma_trigger BEFORE INSERT ON public.personel FOR EACH ROW EXECUTE PROCEDURE public.toplampersonelartirma_fonksiyonu();
 =   DROP TRIGGER toplampersoneltirma_trigger ON public.personel;
       public       postgres    false    228    203            ?
           2620    50302 &   yonetici toplamyoneticiartirma_trigger    TRIGGER     ?   CREATE TRIGGER toplamyoneticiartirma_trigger BEFORE INSERT ON public.yonetici FOR EACH ROW EXECUTE PROCEDURE public.toplamyoneticiartirma_fonksiyonu();
 ?   DROP TRIGGER toplamyoneticiartirma_trigger ON public.yonetici;
       public       postgres    false    230    202            ?
           2620    50289 &   yonetici toplamyoneticiazaltma_trigger    TRIGGER     ?   CREATE TRIGGER toplamyoneticiazaltma_trigger BEFORE DELETE ON public.yonetici FOR EACH ROW EXECUTE PROCEDURE public.toplamyoneticiazaltma_fonksiyonu();
 ?   DROP TRIGGER toplamyoneticiazaltma_trigger ON public.yonetici;
       public       postgres    false    202    215            ?
           2606    41981 #   calisanlar calisanlar_sirketid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.calisanlar
    ADD CONSTRAINT calisanlar_sirketid_fkey FOREIGN KEY (sirketid) REFERENCES public.sirket(id) ON UPDATE CASCADE;
 M   ALTER TABLE ONLY public.calisanlar DROP CONSTRAINT calisanlar_sirketid_fkey;
       public       postgres    false    201    197    2733            ?
           2606    50477 -   calisanlarisyapar calisanlarisyapar_isid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.calisanlarisyapar
    ADD CONSTRAINT calisanlarisyapar_isid_fkey FOREIGN KEY (isid) REFERENCES public.isler(id);
 W   ALTER TABLE ONLY public.calisanlarisyapar DROP CONSTRAINT calisanlarisyapar_isid_fkey;
       public       postgres    false    2747    208    209            ?
           2606    50472 3   calisanlarisyapar calisanlarisyapar_personelid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.calisanlarisyapar
    ADD CONSTRAINT calisanlarisyapar_personelid_fkey FOREIGN KEY (personelid) REFERENCES public.personel(id);
 ]   ALTER TABLE ONLY public.calisanlarisyapar DROP CONSTRAINT calisanlarisyapar_personelid_fkey;
       public       postgres    false    209    2741    203            ?
           2606    50467 3   calisanlarisyapar calisanlarisyapar_yoneticiid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.calisanlarisyapar
    ADD CONSTRAINT calisanlarisyapar_yoneticiid_fkey FOREIGN KEY (yoneticiid) REFERENCES public.yonetici(id);
 ]   ALTER TABLE ONLY public.calisanlarisyapar DROP CONSTRAINT calisanlarisyapar_yoneticiid_fkey;
       public       postgres    false    2739    209    202            ?
           2606    42049    depo depo_sirketid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.depo
    ADD CONSTRAINT depo_sirketid_fkey FOREIGN KEY (sirketid) REFERENCES public.sirket(id) ON UPDATE CASCADE;
 A   ALTER TABLE ONLY public.depo DROP CONSTRAINT depo_sirketid_fkey;
       public       postgres    false    2733    207    197            ?
           2606    50459    isler isler_sirketid_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.isler
    ADD CONSTRAINT isler_sirketid_fkey FOREIGN KEY (sirketid) REFERENCES public.sirket(id);
 C   ALTER TABLE ONLY public.isler DROP CONSTRAINT isler_sirketid_fkey;
       public       postgres    false    208    2733    197            ?
           2606    41968 !   kullanici kullanici_sirketid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_sirketid_fkey FOREIGN KEY (sirketid) REFERENCES public.sirket(id) ON UPDATE CASCADE;
 K   ALTER TABLE ONLY public.kullanici DROP CONSTRAINT kullanici_sirketid_fkey;
       public       postgres    false    199    2733    197            ?
           2606    42036    raporlar raporlar_sirketid_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.raporlar
    ADD CONSTRAINT raporlar_sirketid_fkey FOREIGN KEY (sirketid) REFERENCES public.sirket(id) ON UPDATE CASCADE;
 I   ALTER TABLE ONLY public.raporlar DROP CONSTRAINT raporlar_sirketid_fkey;
       public       postgres    false    205    197    2733            L      x?????? ? ?      T   &   x?3?4?4202?50?5??4?2B0?4E????? ?s?      R   p   x?3?,I?IM???43qw?44?4?2?L??I?,N?L,??4W?<:?'579?$i??TZ?????td#??BvbNfI*??P?(??xt????
??ٙy??@5NڜF ?=... t_"       S   ?   x?3?t*?J??IL:?Q?8???ƣ??l?tJ?L?Rp=:?2?ӱ???Ԝ?lN#N# ?4?\F?!?9?i?y0}??9??%E?y@????ťy??Ɯ?`=F=Ɯ?%???I?9
%?ŉEG6?m??q:??s?Bt UC???qqq ??6?      J   2   x?3??/?M?3??44261?4?2?L?O/?N?31?L?6?4 	??qqq ??
.      V   ?   x???=?@??=Ŝ`??ak??3a3?.?g?????Y?PPM??˛1Qw'I? ?Y?????hjijL<?#??ZG??,???][I[?Cm?h??0??????c??y2Ӵ?n)???%O???cxW`?=???? cFh??????ob􁞵R?Cd??      N   ?   x?M?1?0 ??y??Pd?Ċ?*&6???R??	J????QX`?k`/?㌇???FNǘʠe,`?RE??%X?C툌?ו;p-????n????^O???ly?0>?*?C???`CNQc?S s?c?co)?      P   $   x?3?4?4?4?000?445 SF`? ??????? y??      H      x?3?=??;?*1?+F??? .[?      M   m   x?3??/?M?S=?<???95?????@??D?ȘӄӐ?? ??8]???/???N?J?íҘ?5?(U!??(1??Ȇ?b??ʼ???Ģ#??Lu9???LAzb???? "?$H     