<template>
    <div id="globalHeader">
        <a-row :wrap="false">
            <a-col flex="200px">
                <router-link to="/">
                    <div class="title-bar">
                        <img class="logo" src="../assets/vue.svg" alt="logo" />
                        <div class="title">XM云图库</div>
                    </div>
                </router-link>
            </a-col>
            <a-col flex="auto">
                <a-menu v-model:selectedKeys="current" mode="horizontal" :items="items" @click="handleMenuClick"
                    class="header" />
            </a-col>
            <a-col flex="120px">
                <div class="user-login-status">
                    <a-dropdown>
                        <a-space>
                            <a-avatar :src="loginUserStore.loginUser.userAvatar" />
                            {{ loginUserStore.loginUser.userName ?? '旅客' }}
                        </a-space>
                        <template #overlay>
                            <a-menu>
                                <a-menu-item @click="doLogout">
                                    <LogoutOutlined />
                                    退出登录
                                </a-menu-item>
                            </a-menu>
                        </template>
                    </a-dropdown>
                </div>
            </a-col>
        </a-row>

    </div>
</template>
<script setup lang='ts'>
import { LogoutOutlined, } from '@ant-design/icons-vue'
import { useLoginUserStore } from '@/store/useLoginUserStore'

const loginUserStore = useLoginUserStore()
const router = useRouter()

const current = ref<string[]>([]) // 当前菜单

const items = ref([
    { key: '/', label: '主页', title: '主页' },
    { key: '/login', label: '关于', title: '关于' },
])
// 设置当前高亮菜单
router.afterEach((to, from, next) => {
    current.value = [to.path]
})

function handleMenuClick({ key }) {
    router.push({
        path: key
    })
}

function doLogout() {

}
</script>
<style scoped lang='scss'>
#globalHeader {
    .title-bar {
        display: flex;
        align-items: center;

        .title {
            color: black;
            font-size: 18px;
            margin-left: 16px;
        }

        .logo {
            height: 48px;
        }
    }
}
</style>
