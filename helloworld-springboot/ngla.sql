/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2/9/2018 4:39:42 PM                          */
/*==============================================================*/


drop table LA_COURSE;

drop table LA_CRS_HISTORY;

drop table LA_GOLDEN_SAMPLE;

drop table LA_MESSAGE;

drop table LA_RECORD;

drop table LA_RL_HISTORY;

drop table LA_ROLE;

drop table LA_USER;

/*==============================================================*/
/* Table: LA_COURSE                                             */
/*==============================================================*/
create table LA_COURSE (
   CRS_ID               SERIAL not null,
   CRS_NAME             varchar              not null,
   CRS_PRICE            float                not null,
   CRS_URL              varchar              null,
   CRS_STARTDATE        DATE                 null,
   CRS_ENDDATE          DATE                 null,
   CRS_ACTIVE           BOOL                 not null,
   constraint PK_LA_COURSE primary key (CRS_ID)
);

/*==============================================================*/
/* Table: LA_CRS_HISTORY                                        */
/*==============================================================*/
create table LA_CRS_HISTORY (
   HSTR_USR_ID          varchar              not null,
   HSTR_CRS_ID          int                  not null
);

/*==============================================================*/
/* Table: LA_GOLDEN_SAMPLE                                      */
/*==============================================================*/
create table LA_GOLDEN_SAMPLE (
   SMPL_ID              SERIAL               not null,
   SMPL_NAME            varchar              not null,
   SMPL_RL_ID           int                  not null,
   SMPL_MANDATORY       varchar              not null,
   SMPL_OPTIONAL        varchar              not null,
   SMPL_UPDATE_TIME     TIMESTAMP            not null,
   SMPL_ACTIVE          BOOL                 not null,
   constraint PK_LA_GOLDEN_SAMPLE primary key (SMPL_ID)
);

/*==============================================================*/
/* Table: LA_MESSAGE                                            */
/*==============================================================*/
create table LA_MESSAGE (
   MSG_ID               SERIAL               not null,
   MSG_USER_ID          VARCHAR              not null,
   MSG_CONTENT          VARCHAR              not null,
   MSG_SESSION          INT4                 not null,
   MSG_LEVEL            INT4                 not null,
   MSG_SERIAL           INT4                 not null,
   MSG_CREATE_DATE      TIMESTAMP            not null,
   MSG_ACTIVE           BOOL                 not null,
   MSG_INTENT           VARCHAR              null,
   MSG_ACTION           VARCHAR              null,
   constraint PK_LA_MESSAGE primary key (MSG_ID)
);

/*==============================================================*/
/* Table: LA_RECORD                                             */
/*==============================================================*/
create table LA_RECORD (
   CRD_ID               SERIAL               not null,
   CRD_REQUEST          varchar              null,
   CRD_RESPONSE         varchar              null,
   CRD_TIME             TIMESTAMP            null,
   constraint PK_LA_RECORD primary key (CRD_ID)
);

/*==============================================================*/
/* Table: LA_RL_HISTORY                                         */
/*==============================================================*/
create table LA_RL_HISTORY (
   HSTR_USR_ID          varchar              not null,
   HSTR_RL_NAME         varchar              not null,
   HSTR_RL_HISTORY      varchar              not null,
   HSTR_UPDATE_TIME     TIMESTAMP            not null
);

/*==============================================================*/
/* Table: LA_ROLE                                               */
/*==============================================================*/
create table LA_ROLE (
   RL_ID                SERIAL               not null,
   RL_NAME              varchar              not null,
   RL_BU                varchar              not null,
   RL_TITLE             varchar              null,
   RL_GRADE             varchar              null,
   RL_ACTIVE            BOOL                 not null,
   constraint PK_LA_ROLE primary key (RL_ID)
);

/*==============================================================*/
/* Table: LA_USER                                               */
/*==============================================================*/
create table LA_USER (
   USR_ID               varchar              not null,
   USR_NAME             varchar              not null,
   USR_BUDGET           float                not null,
   USR_BALANCE          float                not null,
   USR_BU               varchar              null,
   USR_TITLE            varchar              null,
   USR_GRADE            varchar              null,
   USR_RL_ID            int                  null,
   USR_ACTIVE           BOOL                 not null,
   USR_SESSION          TIMESTAMP            not null default '0001-01-01 00:00:00',
   constraint PK_LA_USER primary key (USR_ID)
);

