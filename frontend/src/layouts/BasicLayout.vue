<template>
    <div id="basicLayout">
        <a-layout style="min-height: 100vh">
            <a-layout-header class="header"><global-header /></a-layout-header>
            <a-layout-content class="content">
                <router-view />
            </a-layout-content>
            <a-layout-footer>Footer</a-layout-footer>
        </a-layout>
    </div>
</template>

<script setup lang="ts"></script>

<style lang="scss" scoped>
#basicLayout {
    .header {
        padding-inline: 20px;
        background: white;
        color: unset;
        margin-bottom: 1px;
    }

    .content {
        background: linear-gradient(to right, #fefefe, #fff);
        margin-bottom: 28px;
        padding: 20px;
    }
}
</style>