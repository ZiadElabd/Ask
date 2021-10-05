import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        userImage: "",
        questions: [] ,
        cur_question:{},
        users:[],
        followers:[],
        profileData:{},
        profileQuestions:[],
        homeQuestions:[],
        settings:{},
        notifications:[],
    },
    getters: {
        
    },
    mutations: {
        initialiseStore(state) {
            if (localStorage.getItem('userID') ) {
                state.userID = localStorage.getItem('userID');
                state.userName = localStorage.getItem('userName');
                state.userImage = localStorage.getItem('userImage');
            }
        },
        saveUserData:(state , data) =>{
            state.userID = data._id;
            state.userName = data._name;
            localStorage.setItem('userID', data._id);
            localStorage.setItem('userName', data._name);
        },
        saveImage:(state , image) =>{
            state.userImage = image;
            localStorage.setItem('userImage', image);
        },
        saveQuestions:(state , questions) =>{
            state.questions = questions;
        },
        delete(state){
            state.questions = [];
            state.profileData = {};
            state.profileQuestions = [];
        },
        reset(state){
            // Merge rather than replace so we don't lose observers
            // https://stackoverflow.com/a/51653116/14107559
            Object.assign(state, getDefaultState());
            localStorage.setItem('userID', '');
            localStorage.setItem('userName', '');
            localStorage.setItem('userImage','');
        },
        saveAQuestion:(state , question) =>{
            state.cur_question = question;
        },
        saveUsers:(state , users) =>{
            state.users = users;
        },
        saveFollowers:(state , followers) =>{
            state.followers = followers.map(e => {
                return e.userName;
            });
        },
        saveProfileData:(state , profileData) =>{
            state.profileData = profileData;
        },
        saveProfileQuestions:(state , profileQuestions) => {
            state.profileQuestions = profileQuestions;
        },
        saveHomeQuestions:(state , homeQuestions) =>{
            state.homeQuestions = homeQuestions;
        },
        saveSettings:(state , settings) =>{
            state.settings = settings;
        },
        saveNotifications:(state , notifications) =>{
            state.notifications = notifications;
        },
    },
    actions: {
        getImage: async context => {
            try {
                let response = await fetch( "http://localhost:5050/getProfilePhoto/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseText);
                console.log("nav image");
                context.commit('saveImage', response);
            } catch (error) {
                alert('error');
            }
        },
        getQuestions: async context => {
            try {
                let response = await fetch( "http://localhost:5050/getQuestion/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveQuestions',response);
            } catch (error) {
                alert('error');
            }
        },
        getAQuestion: async (context,question_id) => {
            try {
                let response = await fetch( "http://localhost:5050/getAskAnsQuestion/" + store.state.userID  + "/" + question_id, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveAQuestion',response);
            } catch (error) {
                alert('error');
            }
        },
        getNotifications: async context =>{
            try {
                let response = await fetch( "http://localhost:5050/getNotifactions/" + store.state.userID, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveNotifications', response);
            } catch (error) {
                alert('error');
            }
        },
        getUsers: async context =>{
            try {
                let response = await fetch( "http://localhost:5050/getUsers/" + store.state.userID , {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveUsers', response);
            } catch (error) {
                alert('error');
            }
        },
        getFollowers: async context =>{ 
            try {
                let response = await fetch( "http://localhost:5050/getFollowers/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveFollowers', response);
            } catch (error) {
                alert('error');
            }
        },
        loadProfileData: async (context,_name) => { 
            try {
                let response = await fetch( "http://localhost:5050/getProfileData/" + store.state.userID + "/" + _name , {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveProfileData', response);
            } catch (error) {
                alert('error');
            }
        },
        loadProfileQuestions: async (context,_name) => { 
            try {
                let response = await fetch( "http://localhost:5050/getProfileQuestion/" + store.state.userID + "/" + _name , {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveProfileQuestions', response);
            } catch (error) {
                alert('error');
            }
        },
        loadHome: async context => {
            try {
                let response = await fetch( "http://localhost:5050/getHomeQuestion/" + store.state.userID + "/" + store.state.userName , {
                    method: "get"
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveHomeQuestions', response);
            } catch (error) {
                alert('error');
            }
        },
        like: (context,question_id) => {
            fetch(
                "http://localhost:5050/AddLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post"
                }
            );
        },
        unlike: (context,question_id) => {
            fetch(
                "http://localhost:5050/removeLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post"
                }
            );
        },
        loadSettings: async context => {
            try {
                let response = await fetch( "http://localhost:5050/getSettings/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                }).then(checkStatus)
                .then(parseJSON);
                context.commit('saveSettings', response);
            } catch (error) {
                alert('error');
            }
        },
    },
    
});


const getDefaultState = () => {
    return {
        userID:'',
        userName: '',
        userImage: "",
        questions: [] ,
        cur_question:{},
        users:[],
        followers:[],
        profileData:{},
        profileQuestions:[],
        homeQuestions:[],
        settings:{},
        notifications:[],
    }
};

function parseJSON(resp) {
    return resp.json();
}

function parseText(resp) {
    return resp.text();
}

function checkStatus(resp) {
    console.log('status');
    if (resp.status >= 200 && resp.status < 300) {
        console.log('good status');
        return resp;
    }
    console.log('bad status');
    return this.parseJSON(resp).then((resp) => {
        throw resp;
    });
}