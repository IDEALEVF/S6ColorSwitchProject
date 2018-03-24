CREATE TABLE niveau.`niveaux` (
  `num_niveau` int(11) DEFAULT NULL,
  `inti_niveau` varchar(13) DEFAULT NULL,
  `posx` int(11) DEFAULT NULL,
  `posy` int(11) DEFAULT NULL,
  `amortissment` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `color` varchar(13) DEFAULT NULL
);
INSERT INTO niveau.`niveaux` VALUES (1,'NORMAL',190,400,4,10,'BLUE'),(2,'NORMAL',190,400,4,10,'BLUE'),(3,'NORMAL',190,400,4,10,'BLUE'),(1,'ENDLESS',190,400,6,9,'BLUE'),(3,'NORMAL',190,400,4,10,'BLUE');