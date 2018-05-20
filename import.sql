CREATE TABLE `users` (
  `id` varchar(100) NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `gender` int(11) DEFAULT '0',
  `email` text
);

CREATE TABLE `activities` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `name` text NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `ranking` int(11) DEFAULT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL
);

CREATE TABLE `notes` (
  `id` varchar(100) NOT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `name` text NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `time` datetime DEFAULT NULL
);

CREATE TABLE `reminder` (
  `id` varchar(100) NOT NULL,
  `activityId` varchar(100) DEFAULT NULL,
  `message` text,
  `time_left` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1'
);

INSERT INTO `activities`
VALUES ('acti01','userid01','Go To School',1,1,0,'2018-05-15 07:00:00','2018-05-15 18:00:00');
INSERT INTO `activities`
VALUES ('acti02','userid01','Go To Bed',1,1,0,'2018-05-15 22:00:00','2018-05-16 06:00:00');
INSERT INTO `activities`
VALUES ('acti03','userid01','Meeting',1,1,0,'2018-05-16 07:00:00','2018-05-16 09:00:00');
INSERT INTO `activities`
VALUES ('acti04','userid01','Supermarket',1,1,0,'2018-05-16 11:00:00','2018-05-16 11:40:00');
INSERT INTO `activities`
VALUES ('acti05','userid01','Have Lunch',1,1,0,'2018-05-16 12:00:00','2018-05-16 12:30:00');
INSERT INTO `activities`
VALUES ('acti06','userid02','Go To School',1,1,0,'2018-05-15 07:00:00','2018-05-15 18:00:00');
INSERT INTO `activities`
VALUES ('acti07','userid02','Gym',1,1,0,'2018-05-15 19:00:00','2018-05-15 20:00:00');

INSERT INTO `notes`
VALUES ('note01','userid01','Buy Milk',1,1,'2018-05-16 11:00:00');
INSERT INTO `notes`
VALUES ('note02','userid01','Buy Eggs',1,1,'2018-05-16 11:00:00');
INSERT INTO `notes`
VALUES ('note03','userid01','Buy Milk',1,1,'2018-05-16 11:00:00');
INSERT INTO `notes`
VALUES ('note04','userid02','Meet Doctor Martin',1,1,'2018-05-15 09:00:00');
INSERT INTO `notes`
VALUES ('note05','userid02','Drink more water',1,1,'2018-05-15 19:00:00');

INSERT INTO `reminder`
VALUES ('remind01','acti02','For a healthy life',5,1,1);
INSERT INTO `reminder`
VALUES ('remind02','acti03','Bring notebooks',10,1,1);
INSERT INTO `reminder`
VALUES ('remind03','acti04','Ask Laura for extra discount',7,1,1);
INSERT INTO `reminder`
VALUES ('remind04','acti05','More vegetables',8,1,1);
INSERT INTO `reminder`
VALUES ('remind05','acti07','It is time',15,1,1);

INSERT INTO `users` (`id`, `name`, `password`, `gender`, `email`) VALUES
('userid01', 'oliver', '123456', 1, 'oliverqueen@gmail.com'),
('userid02', 'barry', '123456', 1, 'barryallen@gmail.com'),
('userid03', 'john', '123456', 1, 'johndiggle@gmail.com'),
('userid04', 'Kara Danvers', 'null', 1, 'supergirl@gmail.com'),
('userid05', 'Cisco Ramon', 'ciscocute', 1, 'cisco@starlab.com');
