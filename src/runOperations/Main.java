package runOperations;

import model.AllSkills;
import view.UI;

public class Main {
    public static AllSkills allSkills = SkillsDeserialize.deserializeSkills();

    public static void main(String[] args) {
        if (SkillsDeserialize.fileIsEmpty || SkillsDeserialize.noFile) {
            UI.firstStart();
        } else {

        }
        SkillsSerialize.serializeSkills(allSkills);
    }
}
