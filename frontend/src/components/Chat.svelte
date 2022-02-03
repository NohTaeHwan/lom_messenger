<script>
    import { chats } from "../store";

    let chat = ""

    const sendChat = () => {
        if (!chat || !chat.trim()) {
            return
        }
        $chats.push({ chat })
        $chats = $chats
        chat = ""
    }
</script>

<div>
    <div class="chatList" style="height: 800px">
    {#each $chats as chatList}
        <div>{chatList.chat}</div>
    {/each}
    </div>
    <div class="input1" style="flex-grow: 1; display: flex;">
        <input
            bind:value={chat}
            type="text"
            class="input2"
            style="flex-grow: 1;"
            on:keyup={ e => {
              if (e.key === "Enter") sendChat()
            }} />
        <button
            on:click={sendChat}
            style="margin-left: 20px"
        >
            Send
        </button>
    </div>
</div>

<style lang="css">

</style>
