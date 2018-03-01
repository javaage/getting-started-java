/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2/12/2018 9:15:54 AM                         */
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
   HSTR_CRS_ID          int                  not null,
   HSTR_UPDATE_TIME     TIMESTAMP 			 not null
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
   HSTR_RL_ID           INT4                 not null,
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

insert into la_course(CRS_NAME,CRS_STARTDATE,CRS_ENDDATE,CRS_PRICE,CRS_ACTIVE)
values
('Englc: CNS Bi-Weekly Workshop - BU Product Introduction','3/1/2018','3/1/2018',299,true), 
('Englc: Code Craft:The Practice of Writing Excellent Code','3/2/2018','3/2/2018',299,true), 
('Englc: Communicating with Clarity and Confidence in Professional English','3/3/2018','3/3/2018',299,true), 
('Englc: Communication & Influence','3/4/2018','3/4/2018',299,true), 
('Englc: Core Python Programing','3/5/2018','3/5/2018',299,true), 
('Englc: CRDC Business Process & Compliance Training','3/6/2018','3/6/2018',0,true), 
('Englc: CRDC Compliance Workshop for People Manager','3/7/2018','3/7/2018',299,true), 
('Englc: CRDC New Star Program Campus New Hire Orientation','3/8/2018','3/8/2018',299,true), 
('Englc: CRDC New Star Program Orientation','3/9/2018','3/9/2018',299,true), 
('Englc: CRDC Rising Star Program Orientation for Intern','3/10/2018','3/10/2018',299,true), 
('Englc: Data Mining and Analytics: Developing Machine Learning with Python','3/11/2018','3/11/2018',299,true), 
('Englc: Data Mining and Analytics: Developing Web Crawler with Python','3/12/2018','3/12/2018',299,true), 
('Englc: Deep Learning Fundamental: Neural Networks and Algorithm','3/13/2018','3/13/2018',299,true), 
('Englc: Deep Learning with TensorFlow','3/14/2018','3/14/2018',350,true), 
('Englc: Deep Learning: Convolutional Neural Networks','3/15/2018','3/15/2018',350,true), 
('Englc: Deep Learning: Developing Neural Networks with Tensorflow','3/16/2018','3/16/2018',350,true), 
('Englc: Deep Learning: Recurrent Neural Network and Computing Accelation Technology','3/17/2018','3/17/2018',299,true), 
('Englc: Designing Your IOT: Architecture, Protocols and Implementation','3/18/2018','3/18/2018',299,true), 
('Englc: Developing Single Web Page with Angular.JS','3/19/2018','3/19/2018',299,true), 
('Englc: Docker Advanced: Cluster Management and Microservice Development','3/20/2018','3/20/2018',299,true), 
('Englc: Docker Fundamentals: Concept and Development Practice','3/21/2018','3/21/2018',299,true), 
('Englc: Effective Communication for Engineering Sustaining','3/22/2018','3/22/2018',299,true), 
('Englc: EMI Suppression and Anti-interference Design and Case Study','3/23/2018','3/23/2018',299,true), 
('Englc: English Email Writing Workshop','3/24/2018','3/24/2018',299,true), 
('Englc: From Backpack to Professional Effective Communication & Time Management','3/25/2018','3/25/2018',299,true), 
('Englc: From Backpack to Professional Understanding Cross-Culture Impacts & Effective Business Email Writing','3/26/2018','3/26/2018',299,true), 
('Englc: Front-End Web Architect: JavaScript Essential','3/27/2018','3/27/2018',299,true), 
('EngLc: Hadoop 2.0 Architecture and Practice','3/28/2018','3/28/2018',299,true), 
('Englc: High Impact Presentation Skills','3/29/2018','3/29/2018',299,true), 
('Englc: HTML5 & CSS3.0 Development (Filpped Classroom)','3/30/2018','3/30/2018',299,true), 
('Englc: Introduction to Git: Version Control and Management','3/31/2018','3/31/2018',299,true), 
('Englc: Introduction to RESTful Architecture','4/1/2018','4/1/2018',299,true), 
('Englc: Java Spring Training','4/2/2018','4/2/2018',299,true), 
('Englc: JavaScript & CSS2.0 Development (Filpped Classroom)','4/3/2018','4/3/2018',299,true), 
('Englc: Kubernetes Fundamentals: Concept, Architecture and Network Models','4/4/2018','4/4/2018',299,true), 
('Englc: Large Scale Website Architecture Design: Key Technologies','4/5/2018','4/5/2018',299,true), 
('Englc: Linux Virtualization and Hypervisor - KVM, XEN, DOCKER etc','4/6/2018','4/6/2018',230,true), 
('Englc: Machine Learning: Natural Language Processing (NLP)','4/7/2018','4/7/2018',245,true), 
('Englc: Micro Service Architecture and Practice','4/8/2018','4/8/2018',299,true), 
('Englc: Microservice Advanced: Key Technologies and Deployment','4/9/2018','4/9/2018',299,true), 
('Englc: Microservice Application Developing Fundamentals','4/10/2018','4/10/2018',299,true), 
('Englc: Networking Fundamental (CCNA Bootcamp)','4/11/2018','4/11/2018',499,true), 
('Englc: OpenStack Fundamental','4/12/2018','4/12/2018',299,true), 
('Englc: Presenting yourself with Confidence and Ease for Managers','4/13/2018','4/13/2018',299,true), 
('Englc: Python Programming Advanced Part I (Chinese Language)','4/14/2018','4/14/2018',299,true), 
('Englc: Python Programming Fundamental','4/15/2018','4/15/2018',299,true), 
('Englc: Redis NoSql Database Development','4/16/2018','4/16/2018',299,true), 
('Englc: Rising Star Challenge','4/17/2018','4/17/2018',0,true), 
('Englc: Scrum Fundamentals for Teams','4/18/2018','4/18/2018',350,true), 
('Englc: Signal Integrity Series - Channel Inter Symbol Interference and Crosstalk Analysis Methods','4/19/2018','4/19/2018',299,true), 
('Englc: Software Architecture: Best Practice and Case Study','4/20/2018','4/20/2018',299,true), 
('Englc: Spark Fundamentals - Concept, Ecosystem and Applications','4/21/2018','4/21/2018',299,true), 
('Englc: Spark Programming Training','4/22/2018','4/22/2018',299,true), 
('Englc: TCL Programming Fundamentals','4/23/2018','4/23/2018',299,true), 
('Englc: TechDive: Introduction to Virtual Reality','4/24/2018','4/24/2018',299,true), 
('Englc: THE NETWORK.INTUITIVE.Learning Workshop: Catalyst 9K and DNA Licensing Model','4/25/2018','4/25/2018',299,true), 
('Englc: Thermal Design, Analysis and Testing','4/26/2018','4/26/2018',299,true), 
('Englc: TLI - Influential Communication','4/27/2018','4/27/2018',299,true), 
('Englc: TLI - Innovation with Biz Acumen','4/28/2018','4/28/2018',299,true), 
('Englc: Unit Testing Best Practices for Software Developer','4/29/2018','4/29/2018',299,true), 
('Englc: Web Automation Test and CI: Framwork, Methodology and Tools','4/30/2018','4/30/2018',299,true), 
('Englc: Web UI Design Workshop','5/1/2018','5/1/2018',299,true), 
('Englc: WhatsTech: Automatic OpenStack: Ceilometer and Heat','5/2/2018','5/2/2018',299,true), 
('Englc: WhatsTech: Deep Dive to the Technologies of Cisco Intuitive Network','5/3/2018','5/3/2018',299,true), 
('Englc: WhatsTech: IOT Smart?Grid Application?Architecture and Solution','5/4/2018','5/4/2018',299,true), 
('Englc: WhatsTech: JD.com Infrastructure Evolution: Migration from Tradition to Cloud','5/5/2018','5/5/2018',299,true), 
('Englc: WhatsTech: Kubernetes Advanced: Network, Microservice and Usecase','5/6/2018','5/6/2018',299,true), 
('Englc: WhatsTech: Large Scale Website Architecture Design: Case Study from Ali.com and Wikipedia.org','5/7/2018','5/7/2018',299,true), 
('Englc: WhatsTech: OpenStack Networking Deep Dive','5/8/2018','5/8/2018',299,true), 
('Englc: WhatsTech:Large-scale Website Architecture: Key Technologies and Case Study','5/9/2018','5/9/2018',299,true), 
('Englc: White-Box Testing Training','5/10/2018','5/10/2018',299,true), 
('Englc: Written English Communication Workshop','5/11/2018','5/11/2018',299,true), 
('Englc-LSS: 1:1 Virtual English Training: Video with Teachers','5/12/2018','5/12/2018',299,true), 
('Englc-LSS: Agile Leadership Workshop','5/13/2018','5/13/2018',299,true), 
('Englc-LSS: Excel skills (Advanced)','5/14/2018','5/14/2018',299,true), 
('Englc-LSS: PowerPoint skills (Advanced)','5/15/2018','5/15/2018',299,true), 
('Englc-LSS:Oral English Boot Camp','5/16/2018','5/16/2018',299,true), 
('Englc-Tech: Code Refactoring: Improving the Design of Existing Code','5/17/2018','5/17/2018',299,true), 
('Englc-Tech: DevOps Training for WebEx','5/18/2018','5/18/2018',299,true), 
('Englc-Tech: Embedded Linux -  Kernel APIs Introduction','5/19/2018','5/19/2018',299,true), 
('Englc-Tech: Embedded Linux - High-quality C Programming, Testing & Debugging','5/20/2018','5/20/2018',299,true), 
('Englc-Tech: Embedded Linux - Multi-process, Multi-thread Application Development and System Performance Profiling','5/21/2018','5/21/2018',299,true), 
('Englc-Tech: Network Fundamental','5/22/2018','5/22/2018',299,true), 
('Englc-Tech: Performance Testing Tuning','5/23/2018','5/23/2018',299,true), 
('Englc-Tech: Unit Testing Best Practices for Software Developer','5/24/2018','5/24/2018',299,true)
