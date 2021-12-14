<template>
  <div>
    <b-button v-b-toggle.sidebar-no-header>Toggle Sidebar</b-button>
    <b-sidebar id="sidebar-no-header" aria-labelledby="sidebar-no-header-title" no-header shadow>
      <template #default="{ hide }">
        <div class="p-3">
          <h4 id="sidebar-no-header-title">FEAST FINDER</h4>
          <p>
            Welcome to Feast Finder!!! Let us help you feed the beast!!!
          </p>
           <b-img src="PigFeast.png" fluid thumbnail></b-img> 
          <nav class="mb-3">
            <b-nav vertical>
             
              <b-nav-item href="/" @click="hide">Home</b-nav-item>
              <b-nav-item href="/feastForm" @click="hide">FeastForm</b-nav-item>
             <div id="sideBarFeastForm"> <feast-form/></div>
            <b-nav-item href="/logout" @click="hide">Log Out</b-nav-item>
            </b-nav>
          </nav>
          <b-button variant="primary" block @click="hide">Close Sidebar</b-button>
        </div>
      </template>
    </b-sidebar>
  </div>
</template>

<script>

import FeastForm from './feastForm.vue';
export default {
    components: {    
        FeastForm
  }
    
}
</script>

<style scoped>
#sideBarFeastForm{
    width:100%;
    background-color: rgb(109, 104, 104);
}

</style>

