-- 世帯マスタ
INSERT INTO spajam.m_family (family_id, name) VALUES ('1', 'スパ家');
INSERT INTO spajam.m_family (family_id, name) VALUES ('2', 'ジャム家');


-- ユーザマスタ
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('1', '1', 'おとうさん', '1', '');
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('2', '1', 'おかあさん', '1', '');
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('3', '1', 'おじいちゃん', '1', '');
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('4', '1', 'たろう', '2', '');
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('5', '2', 'おとうさん', '1', '');
INSERT INTO spajam.m_user (user_id, family_id, name, division, hash_value) VALUES ('6', '2', 'じろう', '2', '');


-- 仮想通貨マスタ
INSERT INTO spajam.m_virtual_currency (currency_id, name, hash_value, trade_rate) VALUES ('1', 'ゴールド', '', '1');
INSERT INTO spajam.m_virtual_currency (currency_id, name, hash_value, trade_rate) VALUES ('2', 'シルバー', '', '1');
INSERT INTO spajam.m_virtual_currency (currency_id, name, hash_value, trade_rate) VALUES ('3', 'ブロンズ', '', '1');


-- 労働アイテムマスタ
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('1', 'テスト100点', '1', '500');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('2', 'テストけっかがクラスで1位', '1', '1000');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('3', 'がっきゅういいんちょうになる', '1', '3000');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('4', 'なわとび100回', '2', '50');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('5', 'さかがりができるようになる', '2', '750');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('6', 'マラソンたいかいクラスで1位', '2', '250');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('7', 'うんどうかいでかけっこ1位', '2', '250');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('8', 'かたもみ100回する', '3', '10');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('9', 'おかたずけをきちんとした', '3', '5');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('10', 'ごはんのじゅんびをおてつだい', '3', '20');
INSERT INTO spajam.m_work_item (work_item_id, name, currency_id, number) VALUES ('11', 'おふろそうじ', '3', '10');


-- お財布テーブル
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('4', '1', '0');
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('4', '2', '0');
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('4', '3', '0');
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('6', '1', '0');
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('6', '2', '0');
INSERT INTO spajam.t_wallet (user_id, currency_id, number) VALUES ('6', '3', '0');


