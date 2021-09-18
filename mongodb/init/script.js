let dbUser = 'username';
let dbPwd = 'password-test';
let dbName = 'springBootDB';
let dbCollectionName = 'collection';
db = db.getSiblingDB(dbName);
db.createUser({
    'user': dbUser,
    'pwd': dbPwd,
    'roles': [
        {
            'role': 'dbOwner',
            'db': dbName
        }
    ]
});
db.createCollection(dbCollectionName);