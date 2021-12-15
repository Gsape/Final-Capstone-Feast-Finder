<template>
<div>
    <div class="banner">
        <h1 class="brand">Feast Finder</h1>
        <img src="/heart-and-fork.png" class="banner-logo" alt="logo">
    </div>
    <div class=below-banner>
        <side-bar/>
        <div id="nav">
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>
    </div>
</div>
</template>

<script>
import SideBar from '../components/sideBar.vue';
export default {
    components: {
        SideBar
    }

}
</script>

<style>
.banner{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    box-sizing: border-box;
    box-shadow: 0 0 1rem 0 rgba(0, 0, 0, .2); 
    border-radius: 10px;
    background-color: rgba(255, 255, 255, .15);
    backdrop-filter: blur(5px);
    height: 110px;
}
.below-banner{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    box-sizing: border-box;
}

.brand{
    font-family: "Wabeco";
    size: 50px;
    padding-left: 20px;
}
.banner-logo{
    height: 130px;
    width: auto;
    flex: flex-end;
    padding-right: 20px;
}

</style>