PGDMP  *                     |            binarfud_nugrah    16.2    16.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16799    binarfud_nugrah    DATABASE     �   CREATE DATABASE binarfud_nugrah WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE binarfud_nugrah;
                postgres    false            �            1255    16849 C   createuser(character varying, character varying, character varying) 	   PROCEDURE     ,  CREATE PROCEDURE public.createuser(IN username character varying, IN email_address character varying, IN passwords character varying)
    LANGUAGE sql
    AS $$
INSERT INTO public.users
(id, email_address, "password", username)
VALUES(gen_random_uuid (), email_address, passwords, username);
$$;
 �   DROP PROCEDURE public.createuser(IN username character varying, IN email_address character varying, IN passwords character varying);
       public          postgres    false            �            1259    16800    merchant    TABLE     �   CREATE TABLE public.merchant (
    id uuid NOT NULL,
    merchant_location character varying(255),
    merchant_name character varying(255),
    open boolean NOT NULL
);
    DROP TABLE public.merchant;
       public         heap    postgres    false            �            1259    16807    order_detail    TABLE     �   CREATE TABLE public.order_detail (
    id uuid NOT NULL,
    quantity integer NOT NULL,
    total_price double precision NOT NULL,
    id_order uuid,
    id_product uuid
);
     DROP TABLE public.order_detail;
       public         heap    postgres    false            �            1259    16812    orders    TABLE     �   CREATE TABLE public.orders (
    id uuid NOT NULL,
    completed boolean NOT NULL,
    destination_address character varying(255),
    order_time date,
    user_id uuid
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16817    product    TABLE     �   CREATE TABLE public.product (
    id uuid NOT NULL,
    price double precision NOT NULL,
    product_name character varying(255),
    id_merchant uuid
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    16822    users    TABLE     �   CREATE TABLE public.users (
    id uuid NOT NULL,
    email_address character varying(255),
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    16800    merchant 
   TABLE DATA           N   COPY public.merchant (id, merchant_location, merchant_name, open) FROM stdin;
    public          postgres    false    215   �       �          0    16807    order_detail 
   TABLE DATA           W   COPY public.order_detail (id, quantity, total_price, id_order, id_product) FROM stdin;
    public          postgres    false    216   f       �          0    16812    orders 
   TABLE DATA           Y   COPY public.orders (id, completed, destination_address, order_time, user_id) FROM stdin;
    public          postgres    false    217   �                  0    16817    product 
   TABLE DATA           G   COPY public.product (id, price, product_name, id_merchant) FROM stdin;
    public          postgres    false    218   �                 0    16822    users 
   TABLE DATA           F   COPY public.users (id, email_address, password, username) FROM stdin;
    public          postgres    false    219   �       a           2606    16806    merchant merchant_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.merchant
    ADD CONSTRAINT merchant_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.merchant DROP CONSTRAINT merchant_pkey;
       public            postgres    false    215            c           2606    16811    order_detail order_detail_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.order_detail DROP CONSTRAINT order_detail_pkey;
       public            postgres    false    216            e           2606    16816    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    217            g           2606    16821    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    218            i           2606    16828    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    219            l           2606    16839 "   orders fk32ql8ubntj5uh44ph9659tiih    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id);
 L   ALTER TABLE ONLY public.orders DROP CONSTRAINT fk32ql8ubntj5uh44ph9659tiih;
       public          postgres    false    217    219    4713            j           2606    16834 (   order_detail fkicrtfcntxfkyrnoaqh1croidl    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fkicrtfcntxfkyrnoaqh1croidl FOREIGN KEY (id_product) REFERENCES public.product(id);
 R   ALTER TABLE ONLY public.order_detail DROP CONSTRAINT fkicrtfcntxfkyrnoaqh1croidl;
       public          postgres    false    218    4711    216            m           2606    16844 #   product fkr5b0l33kxqkovbqbexr4ub3sc    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkr5b0l33kxqkovbqbexr4ub3sc FOREIGN KEY (id_merchant) REFERENCES public.merchant(id);
 M   ALTER TABLE ONLY public.product DROP CONSTRAINT fkr5b0l33kxqkovbqbexr4ub3sc;
       public          postgres    false    4705    218    215            k           2606    16829 (   order_detail fksta0q8hk1lt2vdu92u4e5vr4a    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fksta0q8hk1lt2vdu92u4e5vr4a FOREIGN KEY (id_order) REFERENCES public.orders(id);
 R   ALTER TABLE ONLY public.order_detail DROP CONSTRAINT fksta0q8hk1lt2vdu92u4e5vr4a;
       public          postgres    false    216    217    4709            �   �   x�M̻�  ����� �F�sg�"��]2�{�Q�կ��	SͅQ4��01�]^r1��s�v^r���̜:�c����r�1�D�ǟ��:�?��Q��A�:�[@�+�T���fʦR�gs�h�!���n�k�QM5v      �      x������ � �      �      x������ � �            x���=�[1�k�� Q�y�4�Dmۋ]����gAJ�@~�f����\@2��G^}F�3`�1��~oǏ�_>bS1j��t0�Dj�{�&��9k��aRɐ+�5���F�1�'���[h�1��Irx�	^����=������4�6 �eyF�@�V4�DO����[��{k�Z��ξt/��5�U��=��槷�ݽL5��!Sw�A�1GN5I���c�v=��u�TY�M�R�N1P��������!��8�A\�{ŕ�<�w��Α�kH�9r���kh!�J�:b+(y��33`�ё|$�����:���}���a6�V�c]&�Ô�|Haepw�jz|�ڧF�+I�X�k�D���ݓ����z��nG��%k]�̵�T��J�L�l��Co�Y:/��~9Ƽ���嵍�G	���'=۶��<�":�%]-O�8�/�y�|Ҫc�G2N~���x�����_�R*i��e�E��H��:]4����u�n����K��?��_hM2�            x������ � �     