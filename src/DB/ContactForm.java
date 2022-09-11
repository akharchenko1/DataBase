package DB;

import DB.NewElements.*;
import DB.Queries.*;
import DB.Tables.SportViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ContactForm extends JFrame {
    JTextField name_field;
    JRadioButton male;
    JRadioButton female;
    JCheckBox check;


    public ContactForm() {
        super("SportDB(main menu)");
        super.setBounds(200, 100, 1000, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(4, 7, 2, 10));

        /*JLabel name = new JLabel("Имя");
        name_field = new JTextField("Фамилия Имя Отчество", 1);

        container.add(name);
        container.add(name_field);

        male = new JRadioButton("Мужской");
        female = new JRadioButton("Женский");

        check = new JCheckBox("Согласен?", false);*/
        JButton SportViews = new JButton("Виды спорта");
        JButton Competitions = new JButton("Соревнования");
        JButton Organisators = new JButton("Организаторы");
        JButton Sportsmen = new JButton("Спортсмены");
        JButton Clubs = new JButton("Спорт-клубы");
        JButton Trainers = new JButton("Тренеры");
        JButton Buildings = new JButton("Здания");

        JButton NewSportView = new JButton("Новый вид спорта");
        JButton NewCompetition = new JButton("Новое соревнование");
        JButton NewOrganisator = new JButton("Новый организатор");
        JButton NewSportsman = new JButton("Новый спортсмен");
        JButton NewClub = new JButton("Новый клуб");
        JButton NewTrainer = new JButton("Новый тренер");
        JButton NewBuilding = new JButton("Новое здание");

        JButton First = new JButton("Первый");
        JButton Second = new JButton("Второй");
        JButton Third = new JButton("Третий");
        JButton Forth = new JButton("Четвертый");
        JButton Fifth = new JButton("Пятый");
        JButton Sixth = new JButton("Шестой");
        JButton Seventh = new JButton("Седьмой");
        JButton Eightth = new JButton("Восьмой");
        JButton Nineth = new JButton("Девятый");
        JButton Tenth = new JButton("Десятый");
        JButton Eleventh = new JButton("Одиннадцатый");
        JButton Twelveth = new JButton("Двенадцатый");
        JButton Thirteenth = new JButton("Тринадцатый");

        container.add(SportViews);
        container.add(Competitions);
        container.add(Organisators);
        container.add(Sportsmen);
        container.add(Clubs);
        container.add(Trainers);
        container.add(Buildings);

        container.add(NewSportView);
        container.add(NewCompetition);
        container.add(NewOrganisator);
        container.add(NewSportsman);
        container.add(NewClub);
        container.add(NewTrainer);
        container.add(NewBuilding);

        container.add(First);
        container.add(Second);
        container.add(Third );
        container.add(Forth );
        container.add(Fifth );
        container.add(Sixth );
        container.add(Seventh);
        container.add(Eightth);
        container.add(Nineth);
        container.add(Tenth );
        container.add(Eleventh);
        container.add(Twelveth);
        container.add(Thirteenth);
        /*male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        container.add(check);
        container.add(Sendbutton);*/


        SportViews.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    DB.Tables.SportViews sportViews = new SportViews();
                    sportViews.setVisible(true);
                    sportViews.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                            SportViews.setEnabled(false);
                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            SportViews.setEnabled(true);
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {

                        }

                        @Override
                        public void windowIconified(WindowEvent e) {

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {

                        }
                    });
                    };
                }
        );
        Competitions.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Competitions competitions = new DB.Tables.Competitions();
                                             competitions.setVisible(true);
                                             competitions.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Competitions.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Competitions.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );
        Organisators.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Organisators organisators = new DB.Tables.Organisators();
                                             organisators.setVisible(true);
                                             organisators.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Organisators.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Organisators.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );
        Sportsmen.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Sportsmen sportsmen = new DB.Tables.Sportsmen();
                                             sportsmen.setVisible(true);
                                             sportsmen.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Sportsmen.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Sportsmen.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );
        Clubs.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Clubs clubs = new DB.Tables.Clubs();
                                             clubs.setVisible(true);
                                             clubs.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Clubs.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Clubs.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );
        Trainers.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Trainers trainers = new DB.Tables.Trainers();
                                             trainers.setVisible(true);
                                             trainers.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Trainers.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Trainers.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );
        Buildings.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             DB.Tables.Buildings buildings = new DB.Tables.Buildings();
                                             buildings.setVisible(true);
                                             buildings.addWindowListener(new WindowListener() {
                                                 @Override
                                                 public void windowOpened(WindowEvent e) {
                                                     Buildings.setEnabled(false);
                                                 }

                                                 @Override
                                                 public void windowClosing(WindowEvent e) {
                                                     Buildings.setEnabled(true);
                                                 }

                                                 @Override
                                                 public void windowClosed(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowIconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeiconified(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowActivated(WindowEvent e) {

                                                 }

                                                 @Override
                                                 public void windowDeactivated(WindowEvent e) {

                                                 }
                                             });
                                         };
                                     }
        );

        NewTrainer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewTrainers newTrainers = new NewTrainers();
                newTrainers.setVisible(true);

            };
                                     }
        );
        NewClub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewClubs newClubs = new NewClubs();
                newClubs.setVisible(true);

            };
        }
        );
        NewSportView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewSportViews newSportViews = new NewSportViews();
                newSportViews.setVisible(true);
            };
        }
        );
        NewOrganisator.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewOrganisators newOrganisators = new NewOrganisators();
                newOrganisators.setVisible(true);
            };
        }
        );
        NewSportsman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewSportsmen newSportsmen = new NewSportsmen();
                newSportsmen.setVisible(true);
            };
        }
        );
        NewCompetition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewCompetitions newCompetitions = new NewCompetitions();
                newCompetitions.setVisible(true);
            };
        }
        );

        NewCompetition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.NewElements.NewCompetitions newCompetitions = new NewCompetitions();
                newCompetitions.setVisible(true);
            };
        }
        );
        First.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.Queries.First first = new First();
                first.setVisible(true);
            };
        }
        );
        Second.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.Queries.Second second = new Second();
                second.setVisible(true);
            };
        }
        );
        Third.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Third third = new Third();
                                         third.setVisible(true);
                                     };
                                 }
        );
        Forth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Forth forth = new Forth();
                                         forth.setVisible(true);
                                     };
                                 }
        );
        Fifth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Fifth fifth = new Fifth();
                                         fifth.setVisible(true);
                                     };
                                 }
        );
        Sixth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Sixth sixth = new Sixth();
                                         sixth.setVisible(true);
                                     };
                                 }
        );
        Seventh.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Seventh seventh = new Seventh();
                                         seventh.setVisible(true);
                                     };
                                 }
        );
        Eightth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Eightth eightth = new Eightth();
                                         eightth.setVisible(true);
                                     };
                                 }
        );
        Nineth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Nineth nineth = new Nineth();
                                         nineth.setVisible(true);
                                     };
                                 }
        );
        Tenth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Tenth tenth = new Tenth();
                                         tenth.setVisible(true);
                                     };
                                 }
        );
        Eleventh.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Eleventh eleventh = new Eleventh();
                                         eleventh.setVisible(true);
                                     };
                                 }
        );
        Twelveth.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                         DB.Queries.Twelveth twelveth = new Twelveth();
                                         twelveth.setVisible(true);
                                     };
                                 }
        );
        Thirteenth.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           DB.Queries.Thirteenth thirteenth = new Thirteenth();
                                           thirteenth.setVisible(true);
                                       };
                                   }
        );
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            /*String name = name_field.getText();

            String isMale = "Мужской";
            if (!male.isSelected()) {
                isMale = "Женский";
            }

            boolean checkBox = check.isSelected();
            JOptionPane.showMessageDialog(null, "Yor male" + isMale + "\n вы согласны?" + checkBox, "Hello"+ name, JOptionPane.PLAIN_MESSAGE );*/
        }
    }
}
