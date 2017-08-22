package com.zncm.dminter

/**
 * {
"login": "aishenlalala",
"id": 18206892,
"avatar_url": "https://avatars0.githubusercontent.com/u/18206892?v=3",
"gravatar_id": "",
"url": "https://api.github.com/users/aishenlalala",
"html_url": "https://github.com/aishenlalala",
"followers_url": "https://api.github.com/users/aishenlalala/followers",
"following_url": "https://api.github.com/users/aishenlalala/following{/other_user}",
"gists_url": "https://api.github.com/users/aishenlalala/gists{/gist_id}",
"starred_url": "https://api.github.com/users/aishenlalala/starred{/owner}{/repo}",
"subscriptions_url": "https://api.github.com/users/aishenlalala/subscriptions",
"organizations_url": "https://api.github.com/users/aishenlalala/orgs",
"repos_url": "https://api.github.com/users/aishenlalala/repos",
"events_url": "https://api.github.com/users/aishenlalala/events{/privacy}",
"received_events_url": "https://api.github.com/users/aishenlalala/received_events",
"type": "User",
"site_admin": false
}
 */

data class MyUser(var login:String,var id:Long,var url:String)
