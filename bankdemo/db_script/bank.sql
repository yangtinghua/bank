-- Table: public.accountdetail

-- DROP TABLE public.accountdetail;

CREATE TABLE public.accountdetail
(
  id integer,
  cardnum character varying,
  type character varying,
  change character varying,
  balance double precision,
  "time" timestamp without time zone
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.accountdetail
  OWNER TO postgres;


-- Table: public.depositaccount

-- DROP TABLE public.depositaccount;

CREATE TABLE public.depositaccount
(
  id integer,
  name character varying,
  password character varying,
  identitynum character varying,
  cardnum character varying,
  phonenum character varying,
  balance double precision,
  rate double precision,
  interest double precision,
  createtime timestamp without time zone,
  count integer,
  begintime timestamp without time zone,
  endtime timestamp without time zone,
  type integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.depositaccount
  OWNER TO postgres;


-- Table: public.loanaccount

-- DROP TABLE public.loanaccount;

CREATE TABLE public.loanaccount
(
  id integer,
  name character varying,
  identitynum character varying,
  cardnum character varying,
  loanlimit double precision,
  credit integer,
  balance double precision,
  rate double precision,
  interest double precision,
  count integer,
  begintime timestamp without time zone,
  endtime timestamp without time zone
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.loanaccount
  OWNER TO postgres;
  
CREATE TABLE usercredit
(
  id integer,
  name character varying,
  identitynum character varying,
  credit integer
 
);

INSERT INTO usercredit(
            id, name, identitynum, credit)
    VALUES (1, 'test1', '111111', 80);
    
INSERT INTO usercredit(
            id, name, identitynum, credit)
    VALUES (2, 'test2', '55555', 80);
    
INSERT INTO usercredit(
            id, name, identitynum, credit)
    VALUES (3, 'test2', '22222', 80);
