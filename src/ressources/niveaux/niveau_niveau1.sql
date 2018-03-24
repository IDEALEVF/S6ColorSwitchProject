CREATE TABLE niveau.`niveau1` (
  `obstacle` varchar(30) DEFAULT NULL,
  `posx` int(11) DEFAULT NULL,
  `posy` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `vitesse` int(11) DEFAULT NULL,
  `rotation` int(11) DEFAULT NULL
);
INSERT INTO niveau.`niveau1` VALUES ('Round1',300,300,10,10,1,0),('CarreDeRonds',190,150,100,100,3,45),('ChangeColor',190,20,45,45,3,0),('MessageColorSwitch',190,400,200,200,3,0),('Doigt',170,420,100,100,0,0),('LigneFin',0,-310,400,50,3,0);
