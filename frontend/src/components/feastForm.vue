<template>
  <div class="form">
    <form v-on:submit.prevent="submitForm" class="q-form">
        <label>
            <h2>Location</h2>
            <label for="zipcode" class="sr-only">Zipcode</label>
                <input
                    type="text"
                    id="zipcode"
                    class="form-control"
                    placeholder="zipcode"
                    required
                    autofocus
                    v:model="form.zip"
                    maxlength="5"
                    minlength="5"
                    v-model="form.zip"
                />   
        </label>    

        <label for="radius" class="sr-only">Radius</label>
                <select name = "radius" id="radius" v-model="form.radius">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="20">20</option>
                    <option value="25">25</option>
                </select> 

        <h2>Feasting Zone</h2>

        <label class="checkbox-form">
        <div class="options" v-for="options in options" v-bind:key="options.id">
            <label class="form-check-label">
                {{ options.type }}
            </label>
            <input
                :id="options.type"
                v-model="form.preferences"
                type="checkbox"
                :value="options.type"
                @change="onChange"
            >
            </div>
        </label>
    </form>
        {{ options.type }}

    <button type="submit" id="submit">Submit</button>
  </div>

</template>

<script>

import Authservice from '@/services/AuthService';

export default {

        data() {
            return {
                options: [
                    {
                        type: 'Thai'
                    },

                    {
                        type: 'Deli'
                    },

                    {
                        type: 'Pizza'
                    },

                    {
                        type: 'Chinese'
                    },

                    {
                        type: 'Healthy'
                    },

                    {
                        type: 'BBQ'
                    },

                    {
                        type: 'Seafood'
                    },

                    {
                        type: 'Italian'
                    },

                    {
                        type: 'Ethiopian'
                    },

                    {
                        type: 'Sushi'
                    }
                ],

                form: {
                    zip: '',
                    radius: '',
                    preferences: []
                },

                methods: {
                    submitForm() {
                        const newForm = {
                            zip: this.form.zip,
                            radius: this.form.radius,
                            preferences: this.form.preferences
                        };

                        Authservice.addForm(newForm)
                        console.log
                    }
                }
        }
    }


//     <template>
// <div>
//     <h1 class ="brandName">Git Forked</h1>
//     <img id ="logo" src="GitForkedLogo (1).png" alt="logo">

//     <form class="q-form">
//         <h2>Location</h2>
//         <label for="zipcode" class="sr-only">Zipcode</label>
//             <input
//                 type="text"
//                 id="zipcode"
//                 class="form-control"
//                 placeholder="zipcode"
//                 required
//                 autofocus
//             />
//         <!-- <label for="radius" class="sr-only">Radius</label>
//             <select name = "radius" id="radius">
//                 <option value="5">5</option>
//                 <option value="10">10</option>
//                 <option value="15">15</option>
//                 <option value="20">20</option>
//                 <option value="25">25</option>
//             </select>  -->

//         <div id="ck-button">
//             <input type="checkbox" id="Thai" value="Thai" v-model="checkedOptions">
//                 <label for="thai">Thai</label>
//             <input type="checkbox" id="Deli" value="Deli" v-model="checkedOptions">
//                 <label for="deli">Deli</label>
//             <input type="checkbox" id="Pizza" value="Pizza" v-model="checkedOptions">
//                 <label for="pizza">Pizza</label>
//             <input type="checkbox" id="Chinese" value="Chinese" v-model="checkedOptions">
//                 <label for="chinese">Chinese</label> 
//             <input type="checkbox" id="Healthy" value="Healthy" v-model="checkedOptions">
//                 <label for="healthy">Healthy</label>
//             <input type="checkbox" id="BBQ" value="BBQ" v-model="checkedOptions">
//                 <label for="bbq">BBQ</label>
//             <input type="checkbox" id="Seafood" value="Seafood" v-model="checkedOptions">
//                 <label for="seafood">Seafood</label>  
//             <input type="checkbox" id="Italian" value="Italian" v-model="checkedOptions">
//                 <label for="italian">Italian</label>
//             <input type="checkbox" id="Ethiopian" value="Ethiopian" v-model="checkedOptions">
//                 <label for="ethiopian">Ethiopian</label>
//             <input type="checkbox" id="Sushi" value="Sushi" v-model="checkedOptions">
//                 <label for="sushi">Sushi</label>                               
//         </div>

//          <button type="submit">Submit</button>
//     </form>
}
</script>

<style>
    * {
        font-family: sa;
    }

    #logo {
    display: block;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    width: 25%;
    }

    h1 {
        text-align: center;
    }

    .form {
        display: block;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 50px;
    }

    .q-form{
    display: block;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 50px;
    width: 50%;
    /* border: 2px solid black;
    border-radius: 5px; */
    }
</style>