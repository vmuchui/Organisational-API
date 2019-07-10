--
-- PostgreSQL database dump
--

-- Dumped from database version 10.9 (Ubuntu 10.9-0ubuntu0.18.10.1)
-- Dumped by pg_dump version 10.9 (Ubuntu 10.9-0ubuntu0.18.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: departments; Type: TABLE; Schema: public; Owner: victor
--

CREATE TABLE public.departments (
    id integer NOT NULL,
    name character varying,
    email character varying
);


ALTER TABLE public.departments OWNER TO victor;

--
-- Name: departments_id_seq; Type: SEQUENCE; Schema: public; Owner: victor
--

CREATE SEQUENCE public.departments_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departments_id_seq OWNER TO victor;

--
-- Name: departments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: victor
--

ALTER SEQUENCE public.departments_id_seq OWNED BY public.departments.id;


--
-- Name: news; Type: TABLE; Schema: public; Owner: victor
--

CREATE TABLE public.news (
    id integer NOT NULL,
    type character varying,
    headlines character varying,
    content character varying,
    departmentid integer
);


ALTER TABLE public.news OWNER TO victor;

--
-- Name: news_id_seq; Type: SEQUENCE; Schema: public; Owner: victor
--

CREATE SEQUENCE public.news_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.news_id_seq OWNER TO victor;

--
-- Name: news_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: victor
--

ALTER SEQUENCE public.news_id_seq OWNED BY public.news.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: victor
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying,
    role character varying,
    rank character varying,
    email character varying,
    departmentid integer
);


ALTER TABLE public.users OWNER TO victor;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: victor
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO victor;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: victor
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: departments id; Type: DEFAULT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.departments ALTER COLUMN id SET DEFAULT nextval('public.departments_id_seq'::regclass);


--
-- Name: news id; Type: DEFAULT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.news ALTER COLUMN id SET DEFAULT nextval('public.news_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: victor
--

COPY public.departments (id, name, email) FROM stdin;
\.


--
-- Data for Name: news; Type: TABLE DATA; Schema: public; Owner: victor
--

COPY public.news (id, type, headlines, content, departmentid) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: victor
--

COPY public.users (id, name, role, rank, email, departmentid) FROM stdin;
\.


--
-- Name: departments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: victor
--

SELECT pg_catalog.setval('public.departments_id_seq', 9, true);


--
-- Name: news_id_seq; Type: SEQUENCE SET; Schema: public; Owner: victor
--

SELECT pg_catalog.setval('public.news_id_seq', 17, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: victor
--

SELECT pg_catalog.setval('public.users_id_seq', 9, true);


--
-- Name: departments departments_pkey; Type: CONSTRAINT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (id);


--
-- Name: news news_pkey; Type: CONSTRAINT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.news
    ADD CONSTRAINT news_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: victor
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

