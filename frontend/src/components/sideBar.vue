<template>
  <div>
    <b-button v-b-toggle.sidebar-no-header id="THEbutton">Feast Form</b-button>
    <b-sidebar id="sidebar-no-header" aria-labelledby="sidebar-no-header-title" no-header shadow>
      <template #default="{ hide }">
        <div class="p-3">

          <!-- <h4 id="sidebar-no-header-title">FEAST FINDER</h4>
          <p>
            Welcome to Feast Finder!!! Let us help you feed the beast!!!
          </p> -->
           <!-- <b-img src="PigFeast.png" fluid thumbnail></b-img>  -->
          <nav class="mb-3">
            <b-nav vertical>
             
              <!-- <b-nav-item href="/" @click="hide">Home</b-nav-item>
              <b-nav-item href="/feastForm" @click="hide">FeastForm</b-nav-item> -->
             <div id="sideBarFeastForm"> <feast-form/></div>
            <!-- <b-nav-item href="/logout" @click="hide">Log Out</b-nav-item> -->
            </b-nav>
          <b-button variant="primary" block @click="hide" class="close">Close Sidebar</b-button>

          </nav>
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
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');
* {
    font-family: 'Open Sans', sans-serif;
}

#sideBarFeastForm{
    width:100%;
    border-radius: 5px;
}

.close {
  margin-bottom: 10px;
  margin: 20px;
  background-color: #6046ED;
  box-shadow: 0px 4px 8px 0px #F887D6;
}

#THEbutton{
  margin: 20px;
  background-color: #6046ED;
  box-shadow: 0px 4px 8px 0px #F887D6;
  width: 180px;
  height: 50px;
  font-size: 20px;
  border-radius: 8px;
}

.p-3{
  background: linear-gradient(45deg, #faf883, #f781ae,#9c3aec, #23d5ab);
}

</style>

