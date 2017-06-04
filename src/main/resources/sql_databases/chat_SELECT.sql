SELECT * FROM chat.message msg JOIN chat.users u
ON (msg.FK_MESSAGE_USER_LOGIN = u.LOGIN)
where u.LOGIN = 'TEST';