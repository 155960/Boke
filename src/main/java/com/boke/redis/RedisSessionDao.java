package com.boke.redis;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class RedisSessionDao extends AbstractSessionDAO {

    @Resource
    JedisUtil jedisUtil;

    private final String SHIRO_SESSION_PREFIX="shiro_session";

    private byte[] getKey(String key){
        return (SHIRO_SESSION_PREFIX+key).getBytes();
    }

    private void saveSession(Session session){
        System.out.println("保存session");
        if(session!=null&&session.getId()!=null){
            byte[] key=getKey(session.getId().toString());
            byte[] value= SerializationUtils.serialize(session);
            jedisUtil.set(key,value);
            //超时时间10分钟
            jedisUtil.expire(key,600);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId=generateSessionId(session);
        assignSessionId(session,sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {

        System.out.println("读取session");
        if(serializable==null){
            return null;
        }
        byte[] key=getKey(serializable.toString());
        byte[] value=jedisUtil.get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("更新session");
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        System.out.println("删除session");
        if(session!=null&&session.getId()!=null){
            byte[] key=getKey(session.getId().toString());
            jedisUtil.delete(key);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys=jedisUtil.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessions=new HashSet<>();
        if(CollectionUtils.isEmpty(keys)){
            return sessions;
        }
        for(byte[] key:keys){
            Session session=(Session) SerializationUtils.deserialize(jedisUtil.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}
