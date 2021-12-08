<template>
<div>
    <h1 class ="brandName">Git Forked</h1>
    <img id ="logo" src="GitForkedLogo (1).png" alt="logo">

    <form class="q-form">
        <h2>Location</h2>
        <label for="zipcode" class="sr-only">Zipcode</label>
            <input
                type="text"
                id="zipcode"
                class="form-control"
                placeholder="zipcode"
                required
                autofocus
            />
        <label for="radius" class="sr-only">Radius</label>
            <select name = "radius" id="radius">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="20">20</option>
                <option value="25">25</option>
            </select> 

        <div id="ck-button">
            <input type="checkbox" id="Thai" value="Thai" v-model="checkedOptions">
                <label for="thai">Thai</label>
            <input type="checkbox" id="Deli" value="Deli" v-model="checkedOptions">
                <label for="deli">Deli</label>
            <input type="checkbox" id="Pizza" value="Pizza" v-model="checkedOptions">
                <label for="pizza">Pizza</label>
            <input type="checkbox" id="Chinese" value="Chinese" v-model="checkedOptions">
                <label for="chinese">Chinese</label> 
            <input type="checkbox" id="Healthy" value="Healthy" v-model="checkedOptions">
                <label for="healthy">Healthy</label>
            <input type="checkbox" id="BBQ" value="BBQ" v-model="checkedOptions">
                <label for="bbq">BBQ</label>
            <input type="checkbox" id="Seafood" value="Seafood" v-model="checkedOptions">
                <label for="seafood">Seafood</label>  
            <input type="checkbox" id="Italian" value="Italian" v-model="checkedOptions">
                <label for="italian">Italian</label>
            <input type="checkbox" id="Ethiopian" value="Ethiopian" v-model="checkedOptions">
                <label for="ethiopian">Ethiopian</label>
            <input type="checkbox" id="Sushi" value="Sushi" v-model="checkedOptions">
                <label for="sushi">Sushi</label>                               
        </div>

         <button type="submit">Submit</button>
    </form>

<!-- v-model="user.zip" needs to be added -->
</div>
</template>

<script>
export default {
    data() {
        return {
        checkedOptions: []
        }
    }
}
</script>

<style>
#logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
  width: 25%;
}

.q-form{
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
  width: 50%;
}

</style>