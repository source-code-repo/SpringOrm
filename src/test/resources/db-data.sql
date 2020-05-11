-- Sample data
INSERT INTO `dept` VALUES (1,'Dept1'),(2,'Dept2'),(3,'Dept3');

INSERT INTO `roletype` VALUES 
    (1,'President','Monthly',250,850,'Senior Management'),
    (2,'VP','Monthly',200,250,'Management'),
    (3,'Employee','Yearly',125,250,'Employee');
    
INSERT INTO `people` VALUES
--                              Role Type ID                   Dept Id                                               Education 
(1,'M P',  'F','President',     1,      'President',     0,    1,      '1901-03-01','1983-01-03 00:00:00',NULL,850,0,'Uni','S','F','None'),
(2,'M VP', 'F','VP',            2,      'Head',          0,    2,      '1980-02-11','1995-11-01 00:00:00',NULL,100,0,'HighSchool','S','F','None');