<template>
    <div>HomePage</div>
</template>
<script setup lang='ts'>

import { test } from '@/api/modules/user'


console.log(import.meta.env);

test().then((res) => {
    console.log(res)
})

</script>
<style scoped lang='scss'></style>
