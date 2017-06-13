

SELECT * FROM chat.users WHERE LOGIN = 'TEST';
SELECT * FROM chat.users WHERE LOGIN LIKE '%TE%';
SELECT * FROM chat.users WHERE LOGIN > 'T';
SELECT * FROM chat.users WHERE LOGIN IN ('TEST');
SELECT * FROM chat.users WHERE PASS IN ('TEST');



SELECT * FROM chat.message msg JOIN chat.users u
ON (msg.FK_MESSAGE_USER_LOGIN = u.LOGIN)
where u.LOGIN = 'TEST';