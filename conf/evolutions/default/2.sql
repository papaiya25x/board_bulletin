# --- !Ups

INSERT INTO t_user
(
  name,
  title,
  message,
  created_at,
  updated_at
)
VALUES
(
  '高海 千歌',
  'はじめて',
  'はじめて食べたmikann',
  TIMESTAMP'1900-01-01 00:00:00',
  TIMESTAMP'1900-01-01 00:00:00'
)
;


# --- !Downs

delete from t_user;
