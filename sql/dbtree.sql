#
# Structure for table "treenode"
#


DROP TABLE IF EXISTS `treenode`;
CREATE TABLE `treenode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) DEFAULT NULL,
  `parentid` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "treenode"
#

INSERT INTO `treenode` VALUES (1,'treenode1',NULL,'0'),(2,'treenode2',NULL,'0'),(3,'treenode3',NULL,'0'),(4,'treenode1-1',NULL,'1'),(5,'treenode1-2',NULL,'1'),(6,'treenode1-1-1',NULL,'4'),(7,'treenode-1-1-2',NULL,'4'),(8,'treenode2-1',NULL,'2'),(9,'treenode2-1-1',NULL,'8');
