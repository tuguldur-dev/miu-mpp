INSERT INTO public.address (city,state,zipcode) VALUES
                                                    ('Fairfield','IA','52556'),
                                                    ('Iowa City','IA','52440'),
                                                    ('Morrison','IL','61270'),
                                                    ('Orlando','FL','34565'),
                                                    ('Tampa','FL','31765');


INSERT INTO public.department ("name") VALUES
                                           ('Tech'),
                                           ('HR'),
                                           ('Finance'),
                                           ('Marketing');

INSERT INTO public.project (project_name,estimated_days,"location") VALUES
                                                                        ('X',180,'FL'),
                                                                        ('Y',60,'FL'),
                                                                        ('Z',80,'IA');


INSERT INTO public.employee ("name",salary,address_id,dept_id) VALUES
                                                                   ('Zaineh',100000,1,1),
                                                                   ('Yasmeen',160000,2,4),
                                                                   ('Mira',140000,3,3),
                                                                   ('Shimaa',200000,4,2),
                                                                   ('Dean',150000,5,1);


INSERT INTO public.employee_project (emp_id,project_id) VALUES
                                                            (115,1),
                                                            (115,2),
                                                            (115,3),
                                                            (114,1),
                                                            (114,3),
                                                            (111,1),
                                                            (111,2);