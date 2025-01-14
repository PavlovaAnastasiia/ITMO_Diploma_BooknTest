PGDMP                  	    |           bookntest_db    16.2    16.2 (               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16946    bookntest_db    DATABASE     �   CREATE DATABASE bookntest_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Ukrainian_Ukraine.1251';
    DROP DATABASE bookntest_db;
                postgres    false            �            1259    16947    roles    TABLE     j   CREATE TABLE public.roles (
    role_id integer NOT NULL,
    role_name character varying(40) NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    16950    roles_role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.roles_role_id_seq;
       public          postgres    false    215                       0    0    roles_role_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.roles_role_id_seq OWNED BY public.roles.role_id;
          public          postgres    false    216            �            1259    16951    services    TABLE     �   CREATE TABLE public.services (
    service_id integer NOT NULL,
    service_name character varying(80) NOT NULL,
    status boolean
);
    DROP TABLE public.services;
       public         heap    postgres    false            �            1259    16954    services_bookings    TABLE       CREATE TABLE public.services_bookings (
    s_b_id integer NOT NULL,
    end_booking time(6) without time zone,
    environment character varying(25) NOT NULL,
    start_booking time(6) without time zone,
    service_id integer,
    email character varying(255),
    b_date date
);
 %   DROP TABLE public.services_bookings;
       public         heap    postgres    false            �            1259    16957    services_bookings_s_b_id_seq    SEQUENCE     �   CREATE SEQUENCE public.services_bookings_s_b_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.services_bookings_s_b_id_seq;
       public          postgres    false    218                       0    0    services_bookings_s_b_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.services_bookings_s_b_id_seq OWNED BY public.services_bookings.s_b_id;
          public          postgres    false    219            �            1259    16958    services_service_id_seq    SEQUENCE     �   CREATE SEQUENCE public.services_service_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.services_service_id_seq;
       public          postgres    false    217                       0    0    services_service_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.services_service_id_seq OWNED BY public.services.service_id;
          public          postgres    false    220            �            1259    16959    teams    TABLE     j   CREATE TABLE public.teams (
    team_id integer NOT NULL,
    team_name character varying(40) NOT NULL
);
    DROP TABLE public.teams;
       public         heap    postgres    false            �            1259    16962    teams_team_id_seq    SEQUENCE     �   CREATE SEQUENCE public.teams_team_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.teams_team_id_seq;
       public          postgres    false    221                       0    0    teams_team_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.teams_team_id_seq OWNED BY public.teams.team_id;
          public          postgres    false    222            �            1259    16963    users    TABLE     �  CREATE TABLE public.users (
    email character varying(120) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(80) NOT NULL,
    middle_name character varying(40) NOT NULL,
    password character varying(50) NOT NULL,
    phone_number character varying(12) NOT NULL,
    profile_picture character varying(40),
    role_id integer,
    team_id integer
);
    DROP TABLE public.users;
       public         heap    postgres    false            c           2604    16966    roles role_id    DEFAULT     n   ALTER TABLE ONLY public.roles ALTER COLUMN role_id SET DEFAULT nextval('public.roles_role_id_seq'::regclass);
 <   ALTER TABLE public.roles ALTER COLUMN role_id DROP DEFAULT;
       public          postgres    false    216    215            d           2604    16967    services service_id    DEFAULT     z   ALTER TABLE ONLY public.services ALTER COLUMN service_id SET DEFAULT nextval('public.services_service_id_seq'::regclass);
 B   ALTER TABLE public.services ALTER COLUMN service_id DROP DEFAULT;
       public          postgres    false    220    217            e           2604    16968    services_bookings s_b_id    DEFAULT     �   ALTER TABLE ONLY public.services_bookings ALTER COLUMN s_b_id SET DEFAULT nextval('public.services_bookings_s_b_id_seq'::regclass);
 G   ALTER TABLE public.services_bookings ALTER COLUMN s_b_id DROP DEFAULT;
       public          postgres    false    219    218            f           2604    16969    teams team_id    DEFAULT     n   ALTER TABLE ONLY public.teams ALTER COLUMN team_id SET DEFAULT nextval('public.teams_team_id_seq'::regclass);
 <   ALTER TABLE public.teams ALTER COLUMN team_id DROP DEFAULT;
       public          postgres    false    222    221                      0    16947    roles 
   TABLE DATA           3   COPY public.roles (role_id, role_name) FROM stdin;
    public          postgres    false    215   �.                 0    16951    services 
   TABLE DATA           D   COPY public.services (service_id, service_name, status) FROM stdin;
    public          postgres    false    217   �.       	          0    16954    services_bookings 
   TABLE DATA           w   COPY public.services_bookings (s_b_id, end_booking, environment, start_booking, service_id, email, b_date) FROM stdin;
    public          postgres    false    218   �/                 0    16959    teams 
   TABLE DATA           3   COPY public.teams (team_id, team_name) FROM stdin;
    public          postgres    false    221   �0                 0    16963    users 
   TABLE DATA           �   COPY public.users (email, first_name, last_name, middle_name, password, phone_number, profile_picture, role_id, team_id) FROM stdin;
    public          postgres    false    223   $1                  0    0    roles_role_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.roles_role_id_seq', 1, false);
          public          postgres    false    216                       0    0    services_bookings_s_b_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.services_bookings_s_b_id_seq', 12, true);
          public          postgres    false    219                       0    0    services_service_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.services_service_id_seq', 1, false);
          public          postgres    false    220                       0    0    teams_team_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.teams_team_id_seq', 1, false);
          public          postgres    false    222            h           2606    16971    roles roles_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    215            l           2606    16973 (   services_bookings services_bookings_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.services_bookings
    ADD CONSTRAINT services_bookings_pkey PRIMARY KEY (s_b_id);
 R   ALTER TABLE ONLY public.services_bookings DROP CONSTRAINT services_bookings_pkey;
       public            postgres    false    218            j           2606    16975    services services_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (service_id);
 @   ALTER TABLE ONLY public.services DROP CONSTRAINT services_pkey;
       public            postgres    false    217            p           2606    16977    teams teams_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (team_id);
 :   ALTER TABLE ONLY public.teams DROP CONSTRAINT teams_pkey;
       public            postgres    false    221            n           2606    16979 -   services_bookings uk5yn1rgsmkl49xff1j0gd0wd02 
   CONSTRAINT     n   ALTER TABLE ONLY public.services_bookings
    ADD CONSTRAINT uk5yn1rgsmkl49xff1j0gd0wd02 UNIQUE (service_id);
 W   ALTER TABLE ONLY public.services_bookings DROP CONSTRAINT uk5yn1rgsmkl49xff1j0gd0wd02;
       public            postgres    false    218            r           2606    16981    users users_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (email);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    223            u           2606    16982 !   users fkfjws1rdruab2bqg7qipoqf65r    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkfjws1rdruab2bqg7qipoqf65r FOREIGN KEY (team_id) REFERENCES public.teams(team_id);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT fkfjws1rdruab2bqg7qipoqf65r;
       public          postgres    false    221    4720    223            s           2606    16987 -   services_bookings fkh3sbnrmxauyoghnvw76mfa65j    FK CONSTRAINT     �   ALTER TABLE ONLY public.services_bookings
    ADD CONSTRAINT fkh3sbnrmxauyoghnvw76mfa65j FOREIGN KEY (email) REFERENCES public.users(email);
 W   ALTER TABLE ONLY public.services_bookings DROP CONSTRAINT fkh3sbnrmxauyoghnvw76mfa65j;
       public          postgres    false    4722    218    223            t           2606    16992 -   services_bookings fkiyptatrtoma119vtb7r20ig29    FK CONSTRAINT     �   ALTER TABLE ONLY public.services_bookings
    ADD CONSTRAINT fkiyptatrtoma119vtb7r20ig29 FOREIGN KEY (service_id) REFERENCES public.services(service_id);
 W   ALTER TABLE ONLY public.services_bookings DROP CONSTRAINT fkiyptatrtoma119vtb7r20ig29;
       public          postgres    false    4714    217    218            v           2606    16997 !   users fkp56c1712k691lhsyewcssf40f    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkp56c1712k691lhsyewcssf40f FOREIGN KEY (role_id) REFERENCES public.roles(role_id);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT fkp56c1712k691lhsyewcssf40f;
       public          postgres    false    223    215    4712               Q   x�3�tI-K��/H-�2��O+)O,JUI-.�es2�R�*r�ӁB&���@�\Ǽ� �˔�%�$΍���� ��         �   x�u�K� ���.8��a���2�ҡ��:���������=@V=�u�g��~A�j�BhQ'�Ö��#��0f�������ͥO�N3�k��׵k�uKً�M�f�|~�,.�n�T9es�DE��.Ҡ���I�(y��2�L6�ם���㢔���p�      	     x����r� ��㻸��'��ȅ�R[T-$V|��⚟�{j��n�(jd5cp�# �Wq��¤��(�k��=�u-#�#˙�J���eڸ}�*ŇR(����_�
�s�#�Ϡ�~��h/D�����|��Y��!�fʩ����Gm��ի��HB��Gl�H����b�U��unͨc��3*w/.R��Q�U�Tb��oX�^�xTy~M��lKM0��X3I���(��MOۅ!?�>��V=��]w\���e��V��         K   x�3��N�KJ�ӽ0����.6]��2⼰�®�6\أ{aTԘ3<�$�(-1'G���[/l�=P�=... i'�         �  x�m�Kn�0@��U
8&����A
c���ڲ�_�]�M�"@�t�]О�0��$gި#*�U� g �yC�F�-!S�����fR�?�O|�������=�GJ?��g�>�{���G<�lU��Q���x�^E��Q��Q���D�K��b�g	�Lz�����B�mz�h�\�j�h�*�!$�\��h6 �.q θ�AY����l�8�r���q{m�ݗ6��K��w��	1�RF�@3�b��\�vٛ<w]��E����y�M��S��G��W��������uZ��R�w0N���h���`«�2�A�m������[�?~�>���w�J�H�_�<�N���N�\�ԙ�P����^F-�J�1m��w���p��eg�I8g�ZԗzѴ���I8�})p��6E�7��=z=�<�7�O+     