package com.padwolf.school.imperialism;

import javax.swing.*;
import java.awt.*;

/**
 * This is the brainpower behind the program. GIANT SWITCH STATEMENTS ARE EVIL!!!
 */
public class Choices extends JPanel{
    JPanel choosePane;
    Frame frame;

    public Choices(Frame parent){
        System.out.println("Initializing 'Choices'");
        frame = parent;
        choosePane = new JPanel();
        choosePane.setLayout(null);
        choosePane.setBackground(Frame.BACKGROUND);
        setLayout(new BorderLayout());


        setBackground(Frame.BACKGROUND);
        setBorder(BorderFactory.createEtchedBorder());

        System.out.println("'Choices' Initialized");
    }

    public JPanel recreateChoosePane(int numOfChoices){
        JPanel op = new JPanel();
        op.setLayout(new GridLayout(1, numOfChoices));
        op.setBackground(Frame.BACKGROUND);

        return op;
    }

    private int rand(int chance){
        return (int)((System.currentTimeMillis()/(Math.pow(chance, 3))*Math.ceil(Math.sqrt(Math.pow(chance, 5)))) % chance);

    }

    public String[] discernFate(String choice){
        System.out.println("Passed choice " + choice);

        String[] rtn;
        switch(choice){
            case "Start Over": rtn = new String[3];
                rtn[0] = "You heard that America is wanting to expand, and you really want to help. Here are your choices:";
                rtn[1] = "Construction Worker";
                rtn[2] = "Soldier";
                break;
            case "Game Over": rtn = discernFate("Start Over"); break;
            //Any --> Retirement
            case "Retire": rtn = new String[2];
                System.out.println();
                System.out.println("You have entered retirement");
                System.out.println();
                rtn[0] = "death";
                rtn[1] = "After a spending most of your life working you decide to retire and live out the rest of your days in peace.";
                break;
            //Construction Worker Branch
            case "Construction Worker":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else {
                    rtn = new String[4];
                    rtn[0] = "You decide to enlist as a construction worker at the Panama Canal. You work long enough to pick your position on the team. Here are your options:";
                    rtn[1] = "Hole Digger";
                    rtn[2] = "Track Remover";
                    rtn[3] = "<html><p align=center>Explosives Expert</p></html>";
                }
                break;
            //Construction Worker --> Hole Digger
            case "Hole Digger":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(20) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You made your hole too deep when the floods came. Your body was found the next week washed up on shore.";
                } else {
                    rtn = new String[4];
                    rtn[0] = "Your task is to manually shovel out the Canal. You work long enough to advance. Here are your options:";
                    rtn[1] = "Soil Analyst";
                    rtn[2] = "<html><p align=center>Steam Shovel Operator</p></html>";
                    rtn[3] = "Pickaxer";
                }
                break;
            //Construction Worker --> Hole Digger --> Soil Analyst
            case "Soil Analyst":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(20) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You made your hole too deep when the floods came. Your body was found the next week washed up on shore.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You survived to the end of your contract. You now have two options in front of you:";
                    rtn[1] = "Retire";
                    rtn[2] = "Start Over";
                }
                break;
            //Construction Worker --> Hole Digger --> Steam Shovel Operator
            case "<html><p align=center>Steam Shovel Operator</p></html>":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(20) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You made your hole too deep when the floods came. Your body was found the next week washed up on shore.";
                }  else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You got caught in some of the machinery of the steam shovel. You should have read the instruction manuel.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You survived to the end of your contract. You now have two options in front of you:";
                    rtn[1] = "Retire";
                    rtn[2] = "Start Over";
                }
                break;
            //Construction Worker --> Hole Digger --> Pickaxer
            case "Pickaxer":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(20) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You made your hole too deep when the floods came. Your body was found the next week washed up on shore.";
                }  else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "A crew member swung their pickaxe back a bit to far. Your head was in the way.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You survived to the end of your contract. You now have two options in front of you:";
                    rtn[1] = "Retire";
                    rtn[2] = "Start Over";
                }
                break;
            //Construction Worker --> Track Remover
            case "Track Remover":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You fall into quicksand. Despite it's name, you die very slowly.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You enlist as part of the crew that removes the train tracks that are being replaced with the Panama Canal. Your job options are:";
                    rtn[1] = "Materials Transport";
                    rtn[2] = "Hole Integrity Analysis";
                }
                break;
            //Construction Worker --> Track Remover --> Materials Transport
            case "Materials Transport":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You fall into quicksand. Despite it's name, you die very slowly.";
                } else if(rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You were attacked by robbers while on one of your transport routes. You were one of the casualties.";
                }else {
                    rtn = new String[3];
                    rtn[0] = "You survived to the end of your contract. You now have two options in front of you:";
                    rtn[1] = "Retire";
                    rtn[2] = "Start Over";
                }
                break;
            //Construction Worker --> Track Remover --> Integrity Analysis
            case "Hole Integrity Analysis":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You fall into quicksand. Despite it's name, you die very slowly.";
                } else if(rand(5) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "One of the holes you were inspecting was not structurally sound. It pays to do your job correctly.";
                } else if(rand(5) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "The hole you were inspecting was too deep when the floods came. Your body was found the next week washed up on shore.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You survived to the end of your contract. You now have two options in front of you:";
                    rtn[1] = "Retire";
                    rtn[2] = "Start Over";
                }
                break;
            //Construction Worker --> Demolitionist
            case "<html><p align=center>Explosives Expert</p></html>":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You realized one second too late that the fuse was way too short. You are now everywhere.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "Explosives expert is just the technical name. People usually call you a demolitionist. You have the honor of blasting holes through mountains. You can choose between:";
                    rtn[1] = "Mountain Tunneling";
                    rtn[2] = "Explosives Field Testing";
                }
                break;
            //Construction Worker --> Demolitionist --> Mountain Tunneling
            case "Mountain Tunneling":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You realized one second too late that the fuse was way too short. You are now everywhere.";
                } else if (rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You suddenly feel shaking as the tunnel you were making caves in. Caves are fun. Cave-ins... Not so much.";
                } else if (rand(12) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You get enlisted as a demolitionist in the army. For now, we'll assume you blow yourself up.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You <italics>somehow</italics> survived to the end of your contract.";
                    rtn[1] = "Flee from evil (Retire)";
                    rtn[2] = "Try life again";
                }
                break;
            //Construction Worker --> Demolitionist --> Mountain Tunneling
            case "Explosives Field Testing":
                if (rand(15) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = cwDeath();
                } else if (rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You realized one second too late that the fuse was way too short. You are now everywhere.";
                } else if (rand(7) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You had one job...<br>And you succeeded.";
                } else if (rand(20) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "The scientists asked you to try out a new type of bomb. They called it the \"Kamikaze\". It turns out, <italics>you</italics> were the bomb.";
                } else if (rand(12) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You get enlisted as a demolitionist in the army. For now, we'll assume you blow yourself up.";
                } else {
                    rtn = new String[3];
                    rtn[0] = "You <italics>somehow</italics> survived to the end of your contract.";
                    rtn[1] = "Flee from evil (Retire)";
                    rtn[2] = "Try life again";
                }
                break;
            case "Flee from evil (Retire)": rtn = discernFate("Retire"); break;
            case "Try life again": rtn = discernFate("Start Over"); break;

            //Finally done with that bit. Now for soldier
            //Soldier Branch
            case "Soldier":
                rtn = new String[4];
                rtn[0] = "Your training ends. You are sent to Cuba to help liberate them from Spain. There are many fields to choose from, but of course, rookies only get three.";
                rtn[1] = "Navy";
                rtn[2] = "Field Op";
                rtn[3] = "Support";
                break;
            case "Navy":
                if (rand(20) == 1){
                    rtn = new String[4];
                    rtn[0] = "You get assigned to the U.S.S. Maine. You were onboard when the ship blew up. You were somehow able to use a piece of shrapnel to float back to Havana harbor. You can now choose to:";
                    rtn[1] = "Stop Fighting";
                    rtn[2] = "<html><p align=center>Continue to fight for the U.S.</html></p>";
                    rtn[3] = "Go Rogue";
                } else {
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You get assigned to the U.S.S. Maine. You were onboard when the ship blew up. Your 5% chance of survival was not enough";
                }
                break;
            case "<html><p align=center>Continue to fight for the U.S.</html></p>":
                rtn = new String[3];
                rtn[0] = "You return to the United States and reenlist. This time, however, they only give you two options.";
                rtn[1] = "Field Op";
                rtn[2] = "Support";
                break;
            case "Stop Fighting": rtn = discernFate("Construction Worker"); break;

            case "Go Rogue":
                rtn = new String[2];
                rtn[0] = "You are 100% sure the U.S. knew that the U.S.S. Maine was going to go down. You decide to fight a one man war against the U.S.";
                rtn[1] = "Continue";
                break;

            case "Continue":
                rtn = new String[2];
                rtn[0] = "death";
                if (rand(4) == 1){
                    rtn[1] = "You evaded capture and death until the end of the Cuban war, and will live out the rest of your days on Cuba.";
                } else if(rand(3) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "In your desperation to harm the US forces, you acted foolishly and got yourself killed. Good job.";
                }
                else {
                    if (rand(2) == 1) {
                        rtn[1] = "You were captured and tried for treason. You have been found guilty and sentenced to death by firing squad.";
                    } else {
                        rtn[1] = "You were captured and tried for treason. You have been found guilty and sentenced to life in prison.";
                    }
                }
                break;

            case "Field Op":
                if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You got shot. It's as simple as that.";
                } else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You are wounded and get sent home. One day you tell your childeren, \"I used to be in the army, then I took a bullet to the knee.\"";
                } else {
                    rtn = new String[4];
                    rtn[0] = "You choose to to the brutal field work. You can choose to be one of the following specialists:";
                    rtn[1] = "General";
                    rtn[2] = "Infantry";
                    rtn[3] = "Demolitionist";
                }
                break;
            case "General":
                if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You got shot. It's as simple as that.";
                } else if (rand(10) == 1){
                    rtn = new String[2];
                    rtn[0] = "death";
                    rtn[1] = "You are wounded and get sent home. One day you tell your childeren, \"I used to be in the army, then I took a bullet to the knee.\"";
                } else {
                    rtn = new String[2];
                    rtn[0] = "Your battle expertise advances you to the rank of General.";
                    rtn[1] = "Uh, Duh!";
                }
                break;
            case "Uh, Duh!":
                rtn = new String[2];
                rtn[0] = "death";
                if (rand(4) == 1){
                    if (rand(4) == 1){
                        rtn[1] = "In the heat of battle, you hear a gunshot as you fall to the floor. Apparently one of your snipers confused you for an enemy.";
                    } else {
                        rtn[1] = "It was a glorious battle... except that you didn't win.";
                    }
                } else{
                    rtn[1] = "Thanks to your efforts, you help America win the war. You live out the rest of your life with much wealth.";
                }
                break;

            case "Infantry":
                rtn = new String[2];
                rtn[0] = "death";
                switch (rand(6)){
                    case 0: rtn[1] = "You step on a land mine and get blown a mile high. Wait... I thought getting blown up was the demolitionist's job."; break;
                    case 1: rtn[1] = "You were cleaning you gun when it went off and killed you."; break;
                    case 2: rtn[1] = "In battle, you see an arrow fall right next to you. While your brain's processing what just happened, another on lands in your chest."; break;
                    default: rtn[1] = "You helped America win the war and Cuba achieve it's freedom."; break;
                }
                break;
            case "Demolitionist":
                rtn = new String[2];
                rtn[0] = "death";
                switch (rand(5)){
                    case 0: rtn[1] = "You just laid that mine, you idiot!"; break;
                    case 1: rtn[1] = "You pointed the bazooka the wrong way"; break;
                    case 2:
                        if (rand(10) == 1){
                            rtn[1] = "It's a good thing the grenade you just pulled the pin to is a dud.";
                        } else {
                            rtn[1] = "That grenade that you just the pin to was live! Why didn't you throw it?!?";
                        }
                        break;
                    default:
                        rtn = new String[3];
                        rtn[0] = "Somehow you survived to the end of your deployment. Do you want to use your skills at the Panama Canal or retire?";
                        rtn[1] = "Panama Canal";
                        rtn[2] = "Retire";
                }
                break;
            case "Panama Canal": rtn = discernFate("<html><p align=center>Explosives Expert</p></html>"); break;

            case "Support":
                rtn = new String[3];
                rtn[0] = "You specialize in specialty weapons. Pick your role:";
                rtn[1] = "Sniper";
                rtn[2] = "Archer";
                break;
            case "Sniper":
                rtn = new String[2];
                rtn[0] = "death";
                if (rand(12) == 1){
                    rtn[1] = "You have been spotted. You have been shotted";
                } else {
                    rtn[1] = "In the heat of battle, you see a general in your sights. Ypu take the shot.";
                    if (rand(4) == 1){
                        rtn[1] += "You go to confirm the kill. You realised that you shot your own general. Good job. You got yourself court-martialed";
                    } else {
                        rtn[1] += "Great shot! That was one of Spain's best. Thanks to this and your other great feats help America to win the war.";
                    }
                }
                break;
            case "Archer":
                rtn = new String[2];
                if (rand(12) == 1){
                    rtn[0] = "death";
                    rtn[1] = "You have been spotted. You have been shotted";
                } else {
                    rtn[0] = "Due to your primitive technology, you get captured by the Spanish Army for questioning. No one expects the Spanish Inquisition.";
                    rtn[1] = "Wonderful. Just wonderful.";
                }
                break;
            case "Wonderful. Just wonderful.":
                rtn = new String[2];
                if (rand(4) == 1){
                    rtn[0] = "You manage to escape. You're not doing that again, so you enlist as a sniper.";
                    rtn[1] = "Great!";
                } else {
                    rtn[0] = "death";
                    rtn[1] = "The Spanish grow impatient with your lack of cooperation. You are K.I.A. (killed in action).";
                }
                break;
            case "Great!": rtn = discernFate("Sniper"); break;

            //Default. Mostly here for debugging.
            default: rtn = new String[2];
                rtn[0] = "death";
                rtn[1] = "IF YOU SEE THIS, THERE IS A BUG WITH THE '" + choice.toUpperCase() + "' CHOICE THAT MUST BE SQUASHED. ALERT PATRICK.";
        }
        return rtn;
    }

    public String cwDeath(){
        switch (rand(4)){
            case 0: return "You died of Malaria. You should have kept those mosquitos out.";
            case 1: return "You died of Yellow Fever. Those bug nets don't seem so bad now, do they?";
            case 2: return "You died by a snake bite. Stop acting like Indiana Jones and get up.";
            case 3: return "You died by Rabies. You shouldn't have pet the monkey.";
            default: return "Umm. Your switch didn't quite work right.";
        }
    }
}