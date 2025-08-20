<template>
    <div id="userLoginPage">
        <h2 class="title">XM云图库 - 用户登录</h2>
        <div class="desc">智能协同云图库</div>
        <a-form :model="formState" name="basic" autocomplete="off" @finish="handleSubmit">
            <a-form-item name="userAccount" :rules="[{ required: true, message: '请输入账号' }]">
                <a-input v-model:value="formState.userAccount" placeholder="请输入账号" />
            </a-form-item>
            <a-form-item name="userPassword" :rules="[
                { required: true, message: '请输入密码' },
                { min: 8, message: '密码长度不能小于 8 位' },
            ]">
                <a-input-password v-model:value="formState.userPassword" placeholder="请输入密码" />
            </a-form-item>
            <div class="tips">
                没有账号？
                <RouterLink to="/user/register">去注册</RouterLink>
            </div>
            <a-form-item>
                <a-button type="primary" html-type="submit" style="width: 100%">登录</a-button>
            </a-form-item>
        </a-form>
    </div>
</template>
<script setup lang='ts'>
import { IUser } from '@/api/interface'
import { ApiUser } from '@/api/modules'
import router from '@/router';
import { useLoginUserStore } from '@/store/useLoginUserStore'
import { message } from 'ant-design-vue';

const { setLoginUser } = useLoginUserStore()

const formState = reactive<IUser.LoginRequest>({
    userAccount: '',
    userPassword: '',
});


function handleSubmit(values: IUser.LoginRequest) {
    // TODO
    ApiUser.userLogin(values).then((data) => {
        setLoginUser(data)
        message.success('登录成功');
        router.push({
            path: '/',
            replace: true
        })
    });

}
</script>
<style scoped lang='scss'>
#userLoginPage {
    max-width: 360px;
    margin: 0 auto;

    .title {
        text-align: center;
        margin-bottom: 16px;
    }

    .desc {
        text-align: center;
        color: #bbb;
        margin-bottom: 16px;
    }

    .tips {
        color: #bbb;
        text-align: right;
        font-size: 13px;
        margin-bottom: 16px;
    }
}
</style>
