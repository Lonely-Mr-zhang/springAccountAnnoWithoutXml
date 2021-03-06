package io.github.lonelyMrZhang.dao;

import io.github.lonelyMrZhang.entity.Account;

import java.util.List;

/**
 * @description: 账户的持久层接口
 * @author: lonely.mr.zhang
 * @date: 2020/6/15 11:37 下午
 */
public interface IAccountDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);
}
